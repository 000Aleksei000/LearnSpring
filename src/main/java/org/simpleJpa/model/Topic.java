package org.simpleJpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Topic implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        category.getTopics().add(this);
        this.category = category;
    }
}

