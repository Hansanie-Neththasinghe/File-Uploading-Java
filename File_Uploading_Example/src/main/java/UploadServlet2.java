

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet2")
@MultipartConfig(
		location = "C:\\Projects\\File_Uploading_Example\\src\\main\\webapp\\images",
		fileSizeThreshold = 1024 * 1024, //1MB
		maxFileSize = 1024 * 1024 * 10,  //10MB
		maxRequestSize = 1024 * 1024 * 31 //31MB
	) 

public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UploadServlet2() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Part part = request.getPart("file");
//		String contentDisposition = part.getHeader("content-disposition");
//		System.out.println("Disposition - " + contentDisposition);
//		response.getWriter().println("test file uploaded");;
		
		String message = "";
		try {
			Part part = request.getPart("file");
			part.write(getFileName(part));
			message = "Your file has been uploaded successfully";
		}catch(Exception e) {
			message = "Error in uploading" + e.getMessage();
		}
		
		try {
			Part part2 = request.getPart("file2");
			part2.write(getFileName(part2));
			message = "Your file has been uploaded successfully";
		}catch(Exception e) {
			message = "Error in uploading" + e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	
	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		
		if(!contentDisposition.contains("filename=")) {
			return null;
		}
		int beginIndex = contentDisposition.indexOf("filename=") + 10;
		int endIndex = contentDisposition.length() -1;
		
		return contentDisposition.substring(beginIndex,endIndex);
	}

}





















