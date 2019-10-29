package com.github.tenx.volleyassignment.Api.models;

import java.util.ArrayList;
import java.util.HashMap;

public class UserResponse {

    private ArrayList<User> results;



    public ArrayList<User> getResults() {
        return results;
    }

    public void setResults(ArrayList<User> results) {
        this.results = results;
    }




    public class User {
        private HashMap<String,String> name;

        public HashMap<String, String> getName() {
            return name;
        }

        public void setName(HashMap<String, String> name) {
            this.name = name;
        }
    }
}
