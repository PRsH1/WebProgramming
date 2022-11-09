package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {

    @Select("select b.*, c.categoryName from book b join category c on b.categoryId=c.id")
    List<Book> findAll();
    @Select("select b.*, c.categoryName from book b join category c on b.categoryId=c.id where b.author like #{ name }")
    List<Book> findByName(String name);
    @Select("select b.*, c.categoryName from book b join category c on b.categoryId=c.id where b.id =#{id}")
    Book findById(int id);
}
