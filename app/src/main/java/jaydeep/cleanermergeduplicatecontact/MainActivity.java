package jaydeep.cleanermergeduplicatecontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.ElementContainers.NumberContainer;
import jagerfield.mobilecontactslibrary.ImportContacts;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "<>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImportContacts importContacts = new ImportContacts(this);
        ArrayList<Contact> listItem = importContacts.getContacts();


        Set<String> sj = new HashSet<>();

        for (int i = 0; i < listItem.size(); i++) {
            sj.add(listItem.get(i).getDisplaydName());
        }

        ArrayList<String> sx = new ArrayList<>(sj);

        ArrayList<UniqContact> uniqs = new ArrayList<>();

        for (int i = 0; i < sx.size(); i++) {
            UniqContact uniqContact = new UniqContact(sx.get(i), new ArrayList<String>());
            uniqs.add(uniqContact);
        }


        for (int i = 0; i < listItem.size(); i++) {


            for (int j = 0; j < uniqs.size(); j++) {
                String g = listItem.get(i).getDisplaydName();
                String n = uniqs.get(j).getName();


                if (g.equals(n)) {


                    UniqContact un = uniqs.get(j);
                    ArrayList<String> ks = un.getNos();

                    LinkedList<NumberContainer> numberContainerLinkedList = listItem.get(i).getNumbers();
                    ArrayList<String> nums = new ArrayList<>();
                    for (int k = 0; k < numberContainerLinkedList.size(); k++) {
                        ks.add(numberContainerLinkedList.get(k).getNormalizedNumber());
                    }
                    Set<String> set = new HashSet<>(ks);
                    ks.clear();
                    ks.addAll(set);


                }
            }

        }



        // ArrayList '  uniqs ' has all the merged contacts, use this for building ui 





        for (int i = 0; i < uniqs.size(); i++) {
            Log.e(TAG, "onCreate: " + uniqs.get(i).getName());
            for (int j = 0; j < uniqs.get(i).getNos().size(); j++) {
                Log.e(TAG, "----------: " + uniqs.get(i).getNos().get(j));
            }
        }



    }




}


//                if (listItem.get(i).getDisplaydName().equals(uniqContactArrayList.get(j).name)) {
//
//                    LinkedList<NumberContainer> numberContainerLinkedList = listItem.get(i).getNumbers();
//
//                    ArrayList<String> nums = new ArrayList<>();
//                    for (int k = 0; k < numberContainerLinkedList.size(); k++) {
//                        nums.add(numberContainerLinkedList.get(k).getNormalizedNumber());
//                    }
//
//                    UniqContact uniqContact = uniqContactArrayList.get(j);
//                    ArrayList<String> numsx = uniqContact.getNos();
//                    numsx.addAll(nums);
//
//
//
//
//                } else {
//                    LinkedList<NumberContainer> numberContainerLinkedList = listItem.get(i).getNumbers();
//
//                    ArrayList<String> nums = new ArrayList<>();
//                    for (int k = 0; k < numberContainerLinkedList.size(); k++) {
//                        nums.add(numberContainerLinkedList.get(k).getNormalizedNumber());
//                    }
//
//                    UniqContact uniqContact = new UniqContact(listItem.get(i).getDisplaydName(), nums);
//                    uniqContactArrayList.add(uniqContact);
//
//                    Log.e(">>>>>%", " "+uniqContact.getName() );
