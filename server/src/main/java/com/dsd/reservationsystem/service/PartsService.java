package com.dsd.reservationsystem.service;

import com.dsd.reservationsystem.database.Db;
import com.dsd.reservationsystem.models.Part;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class PartsService {
  private Db database;

  public PartsService(Db database) {
    this.database = database;
  }

  public Part createPart(Part part) {
    // Generate a unique ID for the part
    String id = UUID.randomUUID().toString();
    part = new Part(id, part.getName(), part.getQuantity(), part.getThreshold());

    // Save the part to Firestore
    database.createPart(part);

    return part;
  }

  public Part getPartById(String id) {
    DocumentReference docRef = database.collection("parts").document(id);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    try {
      document = future.get();
      if (document.exists()) {
        return document.toObject(Part.class);
      } else {
        return null;
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Part> getAllParts() {
    return database.getAllParts();
  }

  public Part postPart(Part part) {
    // Generate a unique ID for the part
    String id = UUID.randomUUID().toString();
    part = new Part(id, part.getName(), part.getQuantity(), part.getThreshold());

    // Save the part to Firestore
    database.createPart(part);

    return part;
  }
}