package br.com.augusto.excell;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import br.com.augusto.controller.entidade.Pessoa;

public class MembrosExcell extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=\"membros.xls\"");
		List<Pessoa> pessoas = (List<Pessoa>) model.get("studentList");
		Sheet sheet = workbook.createSheet("Student Data");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Nome");
		header.createCell(1).setCellValue("Endereco");
		header.createCell(2).setCellValue("Nomme do pai");
		header.createCell(3).setCellValue("Nome da mae");
		header.createCell(4).setCellValue("Data Nascimento");
		header.createCell(5).setCellValue("Endereco");
		header.createCell(6).setCellValue("Telefone");
		header.createCell(7).setCellValue("esta na celula");

		int rowNum = 1;
		for (Pessoa pessoa : pessoas) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(pessoa.getNome_pessoa());
			row.createCell(1).setCellValue(pessoa.getEndereco());
			row.createCell(2).setCellValue(pessoa.getNome_pai());
			row.createCell(3).setCellValue(pessoa.getNome_mae());
			row.createCell(4).setCellValue(pessoa.getData_nascimento().getTime());
			row.createCell(5).setCellValue(pessoa.getEndereco());
			row.createCell(6).setCellValue(pessoa.getTelefones().getTel_residencia()+" | "+pessoa.getTelefones().getTel_whatsapp());
			row.createCell(7).setCellValue(pessoa.isStatus_celula()== true?"sim":"nao");
		}
	}

}
