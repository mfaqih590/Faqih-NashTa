package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.guides.springboot2.springboot2jpacrudexample.dto.ResponseMessage;
import net.guides.springboot2.springboot2jpacrudexample.helper.UploadHelper;
import net.guides.springboot2.springboot2jpacrudexample.model.Mahasiswa;
import net.guides.springboot2.springboot2jpacrudexample.repository.MahasiswaRepository;
import net.guides.springboot2.springboot2jpacrudexample.service.ExcelService;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

@RestController
@RequestMapping("/nashta/v1")
public class MahasiswaController {
	
	@Autowired
	private MahasiswaRepository mahasiswaRepo;
	
	@Autowired
	private ExcelService fileService;
	
	@GetMapping("/mahasiswa")
	public List<Mahasiswa> getAllMahasiswa() {
		return mahasiswaRepo.findAll();
	}
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
//	    String filename= null;

	    if (UploadHelper.hasExcelFormat(file)) {
	      try {
	        fileService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";

	        StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
	        e.printStackTrace(pw);
			String sStackTrace = sw.toString();
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }

	  @GetMapping("/tutorials")
	  public ResponseEntity<List<Mahasiswa>> getAllMhs() {
	    try {
	      List<Mahasiswa> mhs = fileService.getAllMhs();

	      if (mhs.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(mhs, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
