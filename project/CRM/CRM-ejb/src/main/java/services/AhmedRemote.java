package services;

import javax.ejb.Remote;

import entities.Product;

@Remote
public interface AhmedRemote {
void add (Product p);
}
