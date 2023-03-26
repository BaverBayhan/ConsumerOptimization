package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;


import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "generic")
public class GenericTypePost extends Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String formContent;

    public GenericTypePost() {
    }

    public GenericTypePost(Long id, String formContent) {
        this.id = id;
        this.formContent = formContent;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFormContent() {
        return formContent;
    }

    public void setFormContent(String formContent) {
        this.formContent = formContent;
    }
}
