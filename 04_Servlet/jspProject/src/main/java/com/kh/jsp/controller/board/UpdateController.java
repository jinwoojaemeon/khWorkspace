package com.kh.jsp.controller.board;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet(name = "update.bo", urlPatterns = { "/update.bo" })
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// multipart 요청인지 확인
		if(JakartaServletFileUpload.isMultipartContent(request)) {
			
			// 파일 용량 제한 설정
			int fileMaxSize = 1024 * 1024 * 50; // 50MB
			int requestMaxSize = 1024 * 1024 * 60; // 전체 요청 크기 제한
			
			// 파일 저장 경로 설정
			String savePath = request.getServletContext().getRealPath("/resources/board-file/");
			
			// DiskFileItemFactory와 JakartaServletFileUpload 설정
			DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
			JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
			
			upload.setFileSizeMax(fileMaxSize);
			upload.setSizeMax(requestMaxSize);
			
			try {
				List<FileItem> formItems = upload.parseRequest(request);
				
				int boardNo = 0;
				int categoryNo = 0;
				String boardTitle = "";
				String boardContent = "";
				Attachment newAt = null;
				
				// 기존 첨부파일 정보 조회
				BoardService bService = new BoardService();
				Attachment originAt = bService.selectAttachmentByBoardNo(boardNo);
				
				for(FileItem item : formItems) {
					if(item.isFormField()) {
						// 일반 폼 필드 처리
						switch(item.getFieldName()) {
							case "bno":
								boardNo = Integer.parseInt(item.getString(Charset.forName("UTF-8")));
								// boardNo를 알았으므로 기존 첨부파일 정보 다시 조회
								originAt = bService.selectAttachmentByBoardNo(boardNo);
								break;
							case "category":
								categoryNo = Integer.parseInt(item.getString(Charset.forName("UTF-8")));
								break;
							case "title":
								boardTitle = item.getString(Charset.forName("UTF-8"));
								break;
							case "content":
								boardContent = item.getString(Charset.forName("UTF-8"));
								break;
						}
					} else {
						// 파일 처리
						String originName = item.getName();
						
						if(originName.length() > 0) {
							// 새로운 파일이 업로드된 경우
							// 기존 파일이 있다면 삭제
							if(originAt != null) {
								new File(savePath + originAt.getChangeName()).delete();
							}
							
							// 새로운 파일명 생성
							String tmpName = "kh_" + System.currentTimeMillis() + ((int)(Math.random() * 100000) + 1);
							String type = originName.substring(originName.lastIndexOf("."));
							String changeName = tmpName + type;
							
							// 파일 저장
							File f = new File(savePath, changeName);
							item.write(f.toPath());
							
							// 새로운 Attachment 객체 생성
							newAt = new Attachment();
							newAt.setRefBoardNo(boardNo);
							newAt.setOriginName(originName);
							newAt.setChangeName(changeName);
							newAt.setFilePath("resources/board-file/");
						}
					}
				}
				
				// 게시글과 첨부파일 업데이트
				int result = bService.updateBoardWithAttachment(boardNo, categoryNo, boardTitle, boardContent, newAt, originAt);
				
				if(result > 0) {
					request.getSession().setAttribute("alertMsg", "게시글 수정 성공");
					response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
				} else {
					// 실패 시 새로 업로드된 파일 삭제
					if(newAt != null) {
						new File(savePath + newAt.getChangeName()).delete();
					}
					request.setAttribute("errorMsg", "게시글 수정 실패");
					request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "파일 업로드 중 오류가 발생했습니다.");
				request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
