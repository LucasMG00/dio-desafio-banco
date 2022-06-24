package main;

import java.util.*;
import lombok.*;

public class Banco {
	 
	@Getter @Setter private static Map<Integer, String> contas = new HashMap<>();
	@Getter @Setter private static List<String> clientes = new ArrayList<>();
	
	public static String listaDeContas(Map<Integer, String> map){
	    StringBuilder formatar = new StringBuilder("{");
	    for (Integer key : map.keySet()) {
	    	formatar.append(key + " = " + map.get(key) + " \n ");
	    }
	    formatar.delete(formatar.length()-3, formatar.length()).append("}");
	    return formatar.toString();
	}	
}