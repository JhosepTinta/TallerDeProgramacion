package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Archivo {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////ESTA CLASE SE ENCARGA DE GESTIONAR LA LISTA DE CONTACTOS///////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///GUARDA UN CONTACTO EN UN ARCHIVO LLAMADO <<Agenda.txt>> SEPARA CADA DATO POR EL SIGNO <<%>>///
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

	///RECORRE EL ARCHIVO Y DEVOLVERÁ EL NÚMERO DEL CONTACTO QUE SE BUSCA///
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
	
	///RECORRE EL ARCHIVO Y DEVOLVERÁ EL CORREO ELECTRÓNICO DEL CONTACTO QUE SE BUSCA///
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
	
	///RECORRE EL ARCHIVO Y DEVOLVERÁ LA DIRECCIÓN FISICA DEL CONTACTO QUE SE BUSCA///
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
	
	///RECORRE EL ARCHIVO Y SI EL CONTACTO SE ENCUENTRA DENTRO LA LISTA,ESTA SE RESCRIBIRÁ PERO SIN... ///
	///...EL CONTACTO QUE SE DESEA ELIMINAR                                                            ///
	public void eliminarC(Object object,Object object2) {
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
					if((l[0].equals(object))&&(l[1].equals(object2))) {
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
	
	///RECORRE EL ARCHIVO Y SI EL CONTACTO INGRESADO EXISTE ESTO SE RETORNARÁ///
	public boolean existeC(Object object,Object object2) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					if((contacto[0].equals(object))&&(contacto[1].equals(object2))) {
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
	
	///CUENTA LA CANTIDAD DE CONTACTOS QUE TIENE ALMACENADOS EL ARCHIVO///
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
	
	///RETORNA UNA MATRIZ CON LOS CONTACTOS Y LOS DATOS DELOS CONTACTOS ADEMÁS DE TENER LOS CONTACTOS...///
	///...ORDENADOS ALFABETICAMENTE///
	public String[][] mC(){
		String [][]m=enviarMatriz();
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length&&i!=j;j++) {
				if(m[i][0].compareToIgnoreCase(m[j][0])<0) {
					String n=m[i][0];
					String a=m[i][1];
					String nu=m[i][2];
					String c=m[i][3];
					String d=m[i][4];
					m[i][0]=m[j][0];
					m[i][1]=m[j][1];
					m[i][2]=m[j][2];
					m[i][3]=m[j][3];
					m[i][4]=m[j][4];
					m[j][0]=n;
					m[j][1]=a;
					m[j][2]=nu;
					m[j][3]=c;
					m[j][4]=d;
				}
			}
		}
		
		return m;
	}
	///RETORNA UNA MATRIZ CON CONTACTOS Y DATOS PERO SIN ORDEN ALFABETICO///
	private String[][] enviarMatriz() {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String [][]m =new String[numeroC()][5];
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
	///RETORNA UNA MATRIZ MAS PEQUEÑA CON CONTACTOS Y DATOS YA QUE AÑADE SOLO A LAS BUSQUEDAS SEMEJANTES///
	public String[][] MatrizBusqueda(String cadena) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String [][]m =new String[numeroC()][5];
				int numC=0;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					Contacto c = new Contacto(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4]);
					if(cadena.charAt(0)==(contacto[0].charAt(0))) {
					m[numC][0]=contacto[0];
					m[numC][1]=contacto[1];
					m[numC][2]=contacto[2];
					m[numC][3]=contacto[3];
					m[numC][4]=contacto[4];
					numC++;
					}
					else if(Character.isUpperCase(cadena.charAt(0))) {
						char bAux=Character.toLowerCase(cadena.charAt(0));
						if(bAux==(contacto[0].charAt(0))) {
						m[numC][0]=contacto[0];
						m[numC][1]=contacto[1];
						m[numC][2]=contacto[2];
						m[numC][3]=contacto[3];
						m[numC][4]=contacto[4];
						numC++;}
					}
					else if(Character.isLowerCase(cadena.charAt(0))) {
						char bAux=Character.toUpperCase(cadena.charAt(0));
						if(bAux==(contacto[0].charAt(0))) {
						m[numC][0]=contacto[0];
						m[numC][1]=contacto[1];
						m[numC][2]=contacto[2];
						m[numC][3]=contacto[3];
						m[numC][4]=contacto[4];
						numC++;}
					}
					
					
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
	
	///RETORNA UN ArrayList CON LOS NOMBRES Y APELLIDOS DE LOS CONTACTOS///
	public ArrayList<String> contactos(String busqueda){
		ArrayList<String> lista;
		lista=new ArrayList<String>();
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String [][]m =new String[numeroC()][5];
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					Contacto c = new Contacto(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4]);
					if(busqueda.charAt(0)==(contacto[0].charAt(0))) {
					lista.add(contacto[0]+" "+contacto[1]);
					}
					else if(Character.isLowerCase(busqueda.charAt(0))) {
						char bAux=Character.toUpperCase(busqueda.charAt(0));
						if(bAux==(contacto[0].charAt(0))) {
							lista.add(contacto[0]+" "+contacto[1]);
							}
					}
					else if(Character.isUpperCase(busqueda.charAt(0))) {
						char bAux=Character.toLowerCase(busqueda.charAt(0));
						if(bAux==(contacto[0].charAt(0))) {
							lista.add(contacto[0]+" "+contacto[1]);
							}
					}
					
					else if(busqueda.charAt(0)==0) {
						String [][]mAux=mC();
						for(int i=0;i>numeroC();i++) {
							lista.add(mAux[0][i]+" "+mAux[1][i]);
						}
					}
					else {
						String [][]mAux=mC();
						for(int i=0;i>numeroC();i++) {
							lista.add(mAux[0][i]+" "+mAux[1][i]);
						}
					}
			  }
				return lista;
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
	public boolean eCaracter(String caracter) {
		try {
			File file=new File("agenda.txt");
			if(file.exists()) {
				FileReader fr=new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String contacto[]=linea.split("%");
					if(caracter.charAt(0)==(contacto[0].charAt(0))) {
				     return true;     
				}
					else if(Character.isUpperCase(caracter.charAt(0))) {
						char bAux=Character.toLowerCase(caracter.charAt(0));
						if(bAux==(contacto[0].charAt(0))) {
							return true;
							}
					}
					else if(Character.isLowerCase(caracter.charAt(0))) {
						char bAux=Character.toUpperCase(caracter.charAt(0));
						if(bAux==(contacto[0].charAt(0))) {
							return true;
							}
					}
					
			  }
				 return false;
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
	
	}




