package com.tencent.examples.demo.web.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.utils.json.JsonUtil;
import com.tencent.bk.utils.string.StringUtil;
import com.tencent.examples.demo.model.Book;
import com.tencent.examples.demo.model.PageInfo;
import com.tencent.examples.demo.service.BookService;
import com.tencent.examples.dto.RespDto;
import com.tencent.examples.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book/saveBook")
    public @ResponseBody
    String saveBook(Book book){
        RespDto<Book> save = bookService.save(book);
        return JsonUtil.toJson(save);
    }

    @RequestMapping("/book/findbooksByNameAndID")
    public @ResponseBody String findbooksByNameAndID(String name,Integer id,Integer limit,Integer offset){
        PageInfo<List<Book>> pageInfo=new PageInfo<>();
        List<Book> books=new ArrayList<>();
        RespDto<List<Book>> respDto=null;

        if(id==null){
            respDto = bookService.findByLikeName(name);
        }else {
            respDto = bookService.findbooksByNameAndID(id, name);
        }
        books=respDto.getData();
        pageInfo.setRows(books);
        pageInfo.setTotal(books.size());

        return JsonUtil.toJson(pageInfo);
    }

    @RequestMapping("/book/getBookByName")
    public @ResponseBody String getBookByName(String name){
        RespDto<Book> byName = bookService.findByName(name);
        PageInfo<List<Book>> pageInfo=new PageInfo<>();
        List<Book> books=new ArrayList<>();
        books.add(byName.getData());
        pageInfo.setRows(books);
        pageInfo.setTotal(1);
        return JsonUtil.toJson(pageInfo);
    }

    @RequestMapping("/book/getBooksByLikeName")
    public @ResponseBody String getBooksByLikeName(String likename){
        RespDto<List<Book>> byLikeName = bookService.findByLikeName("%"+likename+"%");
        return JsonUtil.toJson(byLikeName);
    }

    @RequestMapping("/book/deleteByBook")
    public @ResponseBody String deleteByBook(Book book){
        RespDto<Integer> delete = bookService.delete(book);
        return JsonUtil.toJson(delete);
    }

    @RequestMapping("/book/deleteByBooks")
    public @ResponseBody String deleteByBooks(String data){
        List<Book> books = JsonUtil.fromJson(data, new TypeReference<List<Book>>() {
        });
        RespDto<List<Book>> delete = bookService.deteleByBooks(books);
        return JsonUtil.toJson(delete);
    }

    @RequestMapping("/book/deleteById")
    public @ResponseBody String deleteById( Integer id){
        RespDto<Integer> delete = bookService.delete(id);
        return JsonUtil.toJson(delete);
    }

    @RequestMapping("/book/getById")
    public @ResponseBody String getById(Integer id){
        RespDto<Book> bookRespDto = bookService.get(id);

        return JsonUtil.toJson(bookRespDto);
    }

    @RequestMapping("/book/getAll")
    public @ResponseBody String getAll(Integer limit,Integer offset,String search,String bookname,Integer bookid){

        PageInfo<List<Book>> pageInfo= new PageInfo<>();

        int pagenum=offset/limit;
        Pageable pageable= new PageRequest(pagenum,limit);

        Specification<Book> specification=null;
        String likename=null;
        if(StringUtil.isNotBlank(search)){
            likename=search;
        }else {
            if(bookid!=null){
                RespDto<List<Book>> respDto = bookService.findbooksByNameAndID(bookid, bookname);
                List<Book> data = respDto.getData();
//                if(data !=null){
//                    pageInfo.setRows(data);
//                    pageInfo.setTotal(1);
//                    return JsonUtil.toJson(pageInfo);
//                }
                pageInfo.setRows(data);
                pageInfo.setTotal(data.size());
                return JsonUtil.toJson(pageInfo);


            }else if (StringUtil.isNotBlank(bookname)){
                likename=bookname;
            }
        }

        final String finallikename=likename;
        if(StringUtil.isNotBlank(finallikename)){
            specification=new Specification<Book>() {
                @Override
                public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                    Path<String> namepath=root.get("name");
                    CriteriaQuery<?> where = query.where(builder.like(namepath, "%" + finallikename + "%"));

                    return null;
                }
            };
        }




        RespDto<Page<Book>> all = bookService.findAll(specification, pageable);
        Page<Book> page = all.getData();
        int total=(int) page.getTotalElements();


        page = all.getData();
        pageInfo.setRows(page.getContent());
        pageInfo.setTotal(total);


        return JsonUtil.toJson(pageInfo);
    }
}
