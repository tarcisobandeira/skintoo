package br.com.MBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@ViewScoped
public class UploadMB {

	String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
	private static String local = "\\resources\\img\\imgProc\\";
	String palavra;

	public File addAnexo(FileUploadEvent event) {
		UploadedFile upFile = event.getFile();

		File caminho = new File(path + local);
		System.out.println(caminho.getPath());
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
