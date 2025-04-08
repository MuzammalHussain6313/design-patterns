package com.design.patterns.Builder;

// Step 1: Define the class with a private constructor
class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;

    // Private constructor to restrict direct instantiation
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // Step 2: Static Inner Builder Class
    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String phone;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    // Display method for testing
    @Override
    public String toString() {
        return "User{ firstName='" + firstName + "', lastName='" + lastName +
                "', age=" + age + ", email='" + email + "', phone='" + phone + "' }";
    }
}


// Step 3: Usage of Builder Pattern
public class BuilderPatternExample {
    public static void main(String[] args) {
        User user = new User.UserBuilder("John", "Doe")
                .setAge(30)
                .setEmail("john.doe@example.com")
                .setPhone("123-456-7890")
                .build();
        System.out.println(user);
    }
}
