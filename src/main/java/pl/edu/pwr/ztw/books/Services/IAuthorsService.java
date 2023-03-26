package pl.edu.pwr.ztw.books.Services;

import pl.edu.pwr.ztw.books.Models.Author;

import java.util.Collection;

public interface IAuthorsService {

    public abstract Collection<Author> getAuthors();
    public abstract Author getAuthor(int id);

    public abstract boolean deleteAuthor(int id);

    public abstract Author createAuthor(Author author);

    public abstract Author updateAuthor(int id, Author author);
}
