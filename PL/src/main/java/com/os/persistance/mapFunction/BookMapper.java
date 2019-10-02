package com.os.persistance.mapFunction;


import com.os.entity.Book;
import com.os.entity.BookAttribute;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class BookMapper implements Mapper<Book> {
    @Override
    public Book getFromResultSet(ResultSet resultSet) throws SQLException, IOException {
        return new Book.BookBuilder()
                .setId(resultSet.getInt("books_translate.id"))
                .setTitle(resultSet.getString("books_translate.title"))
                .setNumberOfPages(resultSet.getInt("number_of_pages"))
                .setAuthor(new AuthorMapper().getFromResultSet(resultSet))
                .setAvailable(resultSet.getBoolean("is_available"))
                .setAddress(resultSet.getString("address"))
                .setBookLanguage(resultSet.getString("book_language"))
                .setPublicationYear(resultSet.getInt("publication_year"))
                .setPublicationOffice(resultSet.getString("publication_office"))
                .setLanguage(new LanguageMapper().getFromResultSet(resultSet))
                .setBase64Image(parseBlob(resultSet))
                .build();
    }


    private String parseBlob(ResultSet resultSet) throws SQLException, IOException {
        Blob blob = resultSet.getBlob("image");
        InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }

        byte[] imageBytes = outputStream.toByteArray();

        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        inputStream.close();
        outputStream.close();
        return base64Image;
    }

    public List<BookAttribute> getBookAttributes(ResultSet resultSet) throws SQLException {
        List<BookAttribute> bookAttributes = new ArrayList<>();

        while (resultSet.next()){
            bookAttributes.add(new BookAttributeMapper().getFromResultSet(resultSet));
        }
        return bookAttributes;

    }

}
