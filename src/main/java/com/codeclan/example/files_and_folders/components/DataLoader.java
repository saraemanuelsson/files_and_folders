package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.User;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRepository;
import com.codeclan.example.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        User harry = new User("Harry Potter");
        userRepository.save(harry);

        User hermione = new User("Hermione Granger");
        userRepository.save(hermione);

        User ron = new User("Ron Weasley");
        userRepository.save(ron);

        Folder parentPics = new Folder("LilyAndJames", harry);
        folderRepository.save(parentPics);

        Folder daMaterial = new Folder("Dumbledore's Army", harry);
        folderRepository.save(daMaterial);

        Folder ancientRunes = new Folder("AncientRunes", hermione);
        folderRepository.save(ancientRunes);

        Folder transfiguration = new Folder("Transfiguration", hermione);
        folderRepository.save(transfiguration);

        Folder quidditchStuff = new Folder("QuidditchStuff", ron);
        folderRepository.save(quidditchStuff);

        Folder scabbers = new Folder("Scabbers", ron);
        folderRepository.save(scabbers);

        File lily = new File("Lily", "jpeg", 10, parentPics);
        fileRepository.save(lily);

        File james = new File("James", "jpeg", 15, parentPics);
        fileRepository.save(james);

        File patronus = new File("How to Patronus", "pdf", 50, daMaterial);
        fileRepository.save(patronus);

        File translation = new File("Translation Homework", "docx", 739, ancientRunes);
        fileRepository.save(translation);

        File animagus = new File("Animagus notes", "txt", 329, transfiguration);
        fileRepository.save(animagus);

        File krum = new File("Krum's autograph", "ppt", 791, quidditchStuff);
        fileRepository.save(krum);

        File ratFacts = new File("Facts about rats", "pdf", 10, scabbers);
        fileRepository.save(ratFacts);

        File ratPic = new File("Scabbers", "jpeg", 43, scabbers);
        fileRepository.save(ratPic);

        parentPics.addFile(lily);
        parentPics.addFile(james);
        folderRepository.save(parentPics);

        daMaterial.addFile(patronus);
        folderRepository.save(daMaterial);

        ancientRunes.addFile(translation);
        folderRepository.save(ancientRunes);

        transfiguration.addFile(animagus);
        folderRepository.save(transfiguration);

        scabbers.addFile(ratFacts);
        scabbers.addFile(ratPic);
        folderRepository.save(scabbers);

        quidditchStuff.addFile(krum);
        folderRepository.save(quidditchStuff);

        harry.addFolder(parentPics);
        harry.addFolder(daMaterial);
        userRepository.save(harry);

        hermione.addFolder(ancientRunes);
        hermione.addFolder(transfiguration);
        userRepository.save(hermione);

        ron.addFolder(scabbers);
        ron.addFolder(quidditchStuff);
        userRepository.save(ron);

    }
}
