package com.os.command.admin;

import com.os.command.Command;
import com.os.entity.Author;
import com.os.entity.Book;
import com.os.entity.Language;
import com.os.service.impl.AuthorServiceImpl;
import com.os.service.impl.BookAttributeServiceImpl;
import com.os.service.impl.BookServiceImpl;
import com.os.service.impl.LanguageServiceImpl;
import com.os.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class AdminAddBookCommand implements Command {
    private BookServiceImpl bookServiceImpl;
    private LanguageServiceImpl languageServiceImpl;
    private AuthorServiceImpl authorServiceImpl;
    private BookAttributeServiceImpl bookAttributeServiceImpl;

    public AdminAddBookCommand(BookServiceImpl bookServiceImpl, LanguageServiceImpl languageServiceImpl, AuthorServiceImpl authorServiceImpl, BookAttributeServiceImpl bookAttributeServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
        this.authorServiceImpl = authorServiceImpl;
        this.bookAttributeServiceImpl = bookAttributeServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("book_title");
        String authorFirstName = request.getParameter("book_author_first_name");
        String authorLastName = request.getParameter("book_author_last_name");
        int numberOfPages = Integer.parseInt(request.getParameter("number_of_pages"));
        String bookLanguage = request.getParameter("book_language");
        String bookAddress = request.getParameter("address");
        int publicationYear = Integer.parseInt(request.getParameter("publication_year"));
        String publicationOffice = request.getParameter("publication_office");
        String attributes = request.getParameter("book_attributes");
        String contentLanguage = request.getParameter("content_language");

        Part filePart = request.getPart("book_image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        String image = new BufferedReader(new InputStreamReader(fileContent))
                .lines().collect(Collectors.joining("\n"));

        Language language = languageServiceImpl.getLanguageByName(contentLanguage);

        Author author = new Author.AuthorBuilder()
                .setFirstName(authorFirstName)
                .setLastName(authorLastName)
                .setLanguage(language)
                .build();
        authorServiceImpl.create(author);

        Book book = new Book.BookBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setAddress(bookAddress)
                .setAvailable(true)
                .setNumberOfPages(numberOfPages)
                .setBookLanguage(bookLanguage)
                .setPublicationYear(publicationYear)
                .setPublicationOffice(publicationOffice)
                .setLanguage(language)
                .setBase64Image(image)
                .build();

        bookServiceImpl.createBook(book);

        Book newBook = bookServiceImpl.getBookById(book.getId());

        bookAttributeServiceImpl.createMany(attributes, language, newBook);

        response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
    }
}
