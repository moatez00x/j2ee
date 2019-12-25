package services;

import javax.ejb.Local;

import entities.Product;

@Local
public interface AhmedLocal {
	void add (Product p);
}
