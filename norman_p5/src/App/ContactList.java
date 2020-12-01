package App;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Files.write;

public class ContactList {
    List<ContactItem> contacts;
    private Object ContactItem;
    private String numberPattern = "1234567890";
    //private String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2 - $3");

    public ContactList() {
        contacts = new ArrayList<ContactItem>();
    }

    // These are all List Option Commands
    public void printContactList() {
        System.out.println("Current Contacts");
        System.out.println("-------------");
        for (ContactItem contact : contacts) {
            System.out.println(String.format("%s) Name: %s %s\nPhone: %s\nEmail: %s", contact.getCounter(), contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail()));
        }
        System.out.print("\n\n\n");
    }

    public void addContactListItem(String firstName, String lastName, String phoneNumber, String email) {
        contacts.add(new ContactItem(firstName, lastName, phoneNumber, email));
    }

    public void editContactListItem(int contactItemNumber, String firstName, String lastName, String phoneNumber, String email, Integer valueOf) {
        for (ContactItem contact : contacts) {
            if (contact.getCounter() == contactItemNumber) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
            }
        }
    }

    public void removeContactListItem(Integer contactItemNumber) {
        Iterator<ContactItem> itty = this.contacts.iterator();
        while (itty.hasNext()) {
            if (itty.next().getCounter() == contactItemNumber) {
                itty.remove();
            }
        }
    }

    public void deleteTempContactList() {
        contacts.clear();
    }

    public void saveContactList(String listFileName) throws IOException {
        StringBuffer sb = new StringBuffer();
        System.out.println("Current Tasks");
        System.out.println("-------------");
        int counter = 0;
        for (ContactItem contact : contacts) {
            sb.append(String.format("%s) Name: %s %s\nPhone: %s\nEmail: %s", contact.getCounter(), contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail()));
            counter++;
            if (counter < contacts.size())
                sb.append("\r\n");
        }

        write(Paths.get(listFileName), sb.toString().getBytes());
        System.out.println("File Saved");
    }

    public static ContactList stringToTaskList(String path) throws IOException {
        ContactList listFile = new ContactList();

        if (new File(path).exists()) {
            byte[] b = readAllBytes(Paths.get(path));
            String d = new String(b, Charset.defaultCharset());

            // delim \r\n splits it up by lines
            StringTokenizer stringTokenizer = new StringTokenizer(d, "\r\n");
            // configure this with phone number and email format
            while(stringTokenizer.hasMoreTokens()){
                String line = stringTokenizer.nextToken();
                Integer counter = Integer.valueOf(line.substring(0, line.indexOf(")")));
                //still failing
                String[] parts = line.substring(line.indexOf(":")+1).trim().split(" ");
                String firstName = parts[0];
                String lastName = parts[1];
                String line2 = stringTokenizer.nextToken();
                String phoneNumber = line2.substring(line.indexOf(":"));
                String line3 = stringTokenizer.nextToken();
                String email = line3.substring(line.indexOf(":"));


                // this has to do with location of brackets and formatting for string
                // currently set up for X) [XXXX-XX-XX]: XXXX XXXX XXXXX format from TaskList
                ContactItem contactItem = new ContactItem(firstName, lastName, phoneNumber, email);
                contactItem.setCounter(counter);
                listFile.contacts.add(contactItem);
            }
        }
        return listFile;
    }
}

