package entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Calendar;
import java.util.HashMap;

@Entity
public class ClassRoom {
    @Id
    private long id;
    @Index
    private String name;
    private String password;
    private String password2;
    @Index
    private String description;
    @Index
    private String email;
    private int status;

    public ClassRoom() {
        initComponent();
    }

    public ClassRoom(String name,String password,String password2 ,String description, String email) {
        initComponent();
        this.name = name;
        this.password =password;
        this.password2 =password2;
        this.description = description;
        this.email = email;
    }
    private void initComponent(){
        this.id = Calendar.getInstance().getTimeInMillis();
        this.status = Status.ACTIVE.getValue();
        this.name = "";
        this.password ="";
        this.password2="";
        this.description = "";
        this.email="";
    }

    public HashMap<String, String> validate() {
        HashMap<String, String> errors = new HashMap<String, String>();
        if (name == null || name.isEmpty()) {
            errors.put("name", "Name is required!");
        }
        if (password == null || password.isEmpty() ) {
            errors.put("password", "Password is required!");
        }
        if (password2 == null || password2.isEmpty() ) {
            errors.put("password2", "Password is required!");
        }
        if(password2.compareTo(password)!=0){
            errors.put("password2","Repeat password does not match");
        }
        if (description == null || description.isEmpty()) {
            errors.put("description", "Description is required!");
        }
        if (email == null || email.isEmpty()) {
            errors.put("email", "Email is required!");
        }
        return errors;
    }

    public enum Status {
        ACTIVE(1), DEACTIVE(0);

        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }
}
