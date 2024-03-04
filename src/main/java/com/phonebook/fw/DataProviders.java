package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1238887463", "kan@gmail.ru", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver2", "Kan", "1238887463", "kan@gmail.ru", "Berlin", "goalkeeper"});
        list.add(new Object[]{"Oliver3", "Kan", "1238887463", "kan@gmail.ru", "Berlin", "goalkeeper"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/сontact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3])
                    .setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
