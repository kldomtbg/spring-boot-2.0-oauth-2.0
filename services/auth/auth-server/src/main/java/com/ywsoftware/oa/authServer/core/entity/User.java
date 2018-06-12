package com.ywsoftware.oa.authserver.core.entity;

//@Entity
//public class User implements AggregateRoot{
//    @Id
//    @Column(nullable = false, length = 36)
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    @GeneratedValue(generator = "system-uuid")
//    private String id;
//
//    @Column(nullable = false)
//    @Pattern(regexp="^[a-zA-Z]\\S{3,12}$",message="输入合法的姓名")
//    private String name;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(nullable = false)
//    @Email
//    private String email;
//
//    @Transient
//    // 该注解可以控制字段不被持久化
//    private String test;
//
//    public User() {
//        super();
//    }
//
//    public String getId() {
//        return this.id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public User(String _id, String _name, String _password, String _email) {
//       this.id = _id;
//        this.name = _name;
//        this.password = _password;
//        this.email = _email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getpassword() {
//        return password;
//    }
//
//    public void setpassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
