package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Archivo {

	public void escribirPersona(Contacto nuevo) {

	
		try {
			File file= new File("agenda.txt");
			FileWriter fw;
			BufferedWriter bw;
			
			if(file.exists()&&file.length()!=0) {
			  fw=new FileWriter(file,true);
			  bw=new BufferedWriter(fw);
			  bw.newLine();
			  bw.write(nuevo.nombre+"%"+nuevo.apellido+"%"+nuevo.numero+"%"+nuevo.correo+"%"+nuevo.direccion);
			  }else {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				bw.write(nuevo.nombre+"%"+nuevo.apellido+"%"+nuevo.numero+"%"+nuevo.correo+"%"+nuevo.direccion);
			  }
			  bw.close();
			  fw.close();
			
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public String buscarN(String nombre,String apellido) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					if((contacto[0].equals(nombre))&&(contacto[1].equals(apellido))) {
					Contacto c = new Contacto(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4]);
				     return contacto[2];
				}
			  }
			}
			else {
				System.out.println("No hay nada por buscar");
				return ("No existe el contacto");
				}
		}catch(Exception e){
			System.out.println(e);
		}
		return ("No existe el Contacto");
	  }
	
	
	public String buscarC(String nombre,String apellido) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					if((contacto[0].equals(nombre))&&(contacto[1].equals(apellido))) {
					Contacto c = new Contacto(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4]);
				     return contacto[3];
				}
			  }
			}
			else {
				System.out.println("No hay nada por buscar");
				return ("No existe el Contacto");
				}
		}catch(Exception e){
			System.out.println(e);
		}
		return ("No existe el Contacto");
	  }
	
	
	public String buscarD(String nombre,String apellido) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					if((contacto[0].equals(nombre))&&(contacto[1].equals(apellido))) {
					Contacto c = new Contacto(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4]);
				     return contacto[4];
				}
			  }
			}
			else {
				System.out.println("No hay nada por buscar");
				return ("No existe el Contacto");
				}
		}catch(Exception e){
			System.out.println(e);
		}
		return ("No existe el Contacto");
	  }
	
	
	public void eliminarC(String nombreE,String apellidoE) {
		try {
		File file=new File("agenda.txt");
		if(file.exists()) {
			FileReader fr= new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int numLineas=0;
			while((linea=br.readLine())!=null) {
				numLineas++;	
			}
			String contactos[]=new String [numLineas];
			br = new BufferedReader (new FileReader(file));
			int i=0;
			while((linea=br.readLine())!=null) {
				contactos[i]=linea;
				i++;
			}
			br.close();
			fr.close();
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			boolean bandera=false;
			boolean primeraL=true;
			for(int j=0;j<contactos.length;j++) {
				String l[]=contactos[j].split("%");
				if((l[0].equals(nombreE))&&(l[1].equals(apellidoE))) {
					bandera=true;
				}
				else {
					if(primeraL==true) {
					bw.write(contactos[j]);
					primeraL=false;}
					else {
						bw.newLine();
						bw.write(contactos[j]);
					}
				}
			}
			if(bandera=false) {
			}
			bw.close();
			fw.close();
			if(numLineas==1 && bandera==true) {
				file.delete();
			}
			
		}else {
			System.out.println("No hay contactos para eliminar");
			JOptionPane.showMessageDialog(null, "No existe el Contacto");
		}
	    }catch(Exception e){
	    	System.out.println(e);
		}
	}
	
	public boolean existeC(String nombre,String apellido) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					if((contacto[0].equals(nombre))&&(contacto[1].equals(apellido))) {
				     return true;
				}
			  }
			}
			else {
				System.out.println("No hay nada por buscar");
				return false;
				}
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	  }
	
	public int numeroC() {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				int numero=0;
				while((linea=br.readLine())!=null) {					
					numero++;
			  }
				return numero;
			}
			else {
				System.out.println("No hay nada por buscar");
				return 0;
				}
		}catch(Exception e){
			System.out.println(e);
		}
		return 0;
	  }
	
	public String[][] enviarMatriz(String [][]m) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				int numC=0;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					Contacto c = new Contacto(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4]);
					m[numC][0]=contacto[0];
					m[numC][1]=contacto[1];
					m[numC][2]=contacto[2];
					m[numC][3]=contacto[3];
					m[numC][4]=contacto[4];
					numC++;
			  }
				return m;
			}
			else {
				System.out.println("No hay nada por buscar");
				return null;
				}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	  }
	
	}
