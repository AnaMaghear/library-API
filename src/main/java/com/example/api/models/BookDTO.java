package com.example.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class BookDTO {
    private UUID id;
    private String title;
    private String author;
}
