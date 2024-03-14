package service.serviceImpl;

import models.Database;
import models.Library;
import service.LibraryService;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {

        Database.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {

        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if(library.getId() == id){
                return library;
            }
        }
        return null;
    }

    @Override
    public void updateLibrary(Long id, Library library) {
        for (Library library1 : Database.libraries) {
            if(library1.getId() == id){
                 Database.libraries.set(Math.toIntExact(id),library);
            }
        }
    }

    @Override
    public String deleteLibrary(Long id) {

        for (Library library : Database.libraries) {
            if(library.getId() == id){
                Database.libraries.remove(library);
            }
        }
        return "successfully deleted";
    }
}
