package br.com.MBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.primefaces.model.file.UploadedFile;


public class UploadMB {

	private static String local = "\\resources\\img\\imgProc\\";
	String palavra;

	public File addAnexo(UploadedFile upFile) {

		File caminho = new File(local);

		testeCaminho(caminho);

		File file = new File(caminho, trocaNomeFile(upFile.getFileName()));
		try {
			OutputStream out = new FileOutputStream(file);
			try {
				out.write(upFile.getContent());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return file;
	}

	public void testeCaminho(File caminho) {
		if (!caminho.exists()) {
			caminho.mkdirs();
			System.out.println("SkinToo:Diretório criado.");
		} else {
			System.out.println("SkinToo:Diretório já existe.");
		}
	};

	public String trocaNomeFile(String arquivo) {
		String nome = null;
		String arquivoN = arquivo.replace('.', '#');
		String[] s = arquivoN.split("#");

		for (int i = 0; i < s.length; i++) {
			palavra = s[i].trim();
		}

		long l = Calendar.getInstance().getTimeInMillis();

		nome = l + "." + palavra;
		return nome;
	}

	public static String getLocal() {
		return local;
	}

	public static void setLocal(String local) {
		UploadMB.local = local;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

}
