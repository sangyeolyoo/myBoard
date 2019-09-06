package com.example.demo.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.cookie.CookieHandler;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.Pagination;
import com.example.demo.service.BoardService;
import com.example.demo.service.CommentService;
import com.example.demo.view.FileDownloadView;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	CommentService commentService;
	
	@Autowired
	FileDownloadView fildownloadView;

	@RequestMapping("/")
	public String rootTest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Cookie[] cookies = request.getCookies();
		CookieHandler cookieHandler = new CookieHandler();

		for (Cookie cook : cookieHandler.delete(cookies)) {
			response.addCookie(cook);
		}
		return "boardList";
	}

	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public String boardList(ModelMap model,
			@RequestParam(defaultValue = "1") int curPage,
			@ModelAttribute("board") BoardVO boardVO) throws Exception {

		int listCnt = boardService.getBoardListCnt(boardVO);
		Pagination pagination = new Pagination(listCnt, curPage);
		System.out.println(curPage);
		System.out.println(boardVO.toString());

		boardVO.setStartIndex(pagination.getStartIndex());
		boardVO.setCntPerPage(pagination.getPageSize());

		model.addAttribute("board", boardService.getAll(boardVO));
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);
		return "boardList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchView(ModelMap model,
			@RequestParam(defaultValue = "1") int curPage,
			@ModelAttribute BoardVO boardVO) throws Exception {

		System.out.println("[search]");
		int listCnt = boardService.getBoardListCnt(boardVO);
		Pagination pagination = new Pagination(listCnt, curPage);

		boardVO.setStartIndex(pagination.getStartIndex());
		boardVO.setCntPerPage(pagination.getPageSize());

		System.out.println("listCnt:" + listCnt);
		System.out.println("curPage:" + curPage);
		System.out.println(boardVO.toString());
		System.out.println(pagination.toString());

		model.addAttribute("board", boardService.getAll(boardVO));
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);
		return "boardList";
	}

	@RequestMapping(value = "/regView")
	public String regView(Model model) throws Exception {
		return "insert";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(@ModelAttribute BoardVO boardVO,
			@RequestPart MultipartFile files) throws Exception {
		
		FileVO file = new FileVO(); 
		
		if (files.isEmpty()) {
			boardService.add(boardVO);
		} else {

			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(
					fileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
			//String fileUrl = "C:/ysy/sample-master/src/main/webapp/WEB-INF/uploadFiles/";
			String fileUrl = "store directory"; 

			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32)
						+ "." + fileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName);
			} while (destinationFile.exists());

			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);

			boardService.add(boardVO);
			
			file.setBno(boardVO.getBno());
			file.setFileName(destinationFileName);
			file.setFileOriName(fileName);
			file.setFileUrl(fileUrl);
			
			boardService.fileAdd(file);
			
		}
		return "redirect:boardView";
	}

	@RequestMapping(value = "/editView", method = RequestMethod.POST)
	public String editView(ModelMap model, @ModelAttribute BoardVO boardVO)
			throws Exception {

		BoardVO boardVO2 = boardService.getBoard(boardVO.getBno());
		model.addAttribute("board", boardVO2);
		return "update";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute BoardVO boardVO) throws Exception {
		boardService.edit(boardVO);
		return "redirect:boardView";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailView(ModelMap model, @ModelAttribute BoardVO boardVO,
			HttpServletResponse response, HttpServletRequest request, @RequestParam("bno") int bno)
			throws Exception {

		CookieHandler cookieHandler = new CookieHandler();

		Cookie[] cookies = request.getCookies();
		if (cookieHandler.isCookie(boardVO.getBno(), cookies))
			model.addAttribute("board", boardService.getBoard(boardVO.getBno()));
		else
			model.addAttribute("board", boardService.read(boardVO.getBno()));

		model.addAttribute("files", boardService.fileDetail(bno));
		model.addAttribute("comment",
				commentService.getComment(boardVO.getBno()));
		response.addCookie(cookieHandler.setCookie(boardVO.getBno()));

		return "detail";
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public String refreshView(ModelMap model,
			@RequestParam(value = "delCheck[]") List<Integer> idxArr)
			throws Exception {

		boardService.delByCheck(idxArr);
		return "success";
	}
	
	@RequestMapping(value="/filedown/{bno}", method=RequestMethod.GET)
	public ModelAndView fileDownload(@PathVariable int bno) throws Exception{
		FileVO fileVO = boardService.fileDetail(bno);
		System.out.println(fileVO.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.setView(fildownloadView);
		
		
		File downloadFile = new File(fileVO.getFileUrl(), fileVO.getFileName());
		File test = new File(fileVO.getFileOriName());
		if(!downloadFile.canRead()){
			throw new Exception("File can't read");
		}
		
		mav.addObject("downloadFile", downloadFile);
		mav.addObject("fileOriName", test);
		
		
		return mav;
	}
	
	
////	@RequestMapping(value="/filedown/{bno}")
////	public void fileDown(@PathVariable int bno, HttpServletRequest request, HttpServletResponse response) throws Exception {
//	
//	@RequestMapping(value="/filedown")
//	public void fileDown(@RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		request.setCharacterEncoding("UTF-8");
//		FileVO fileVO = boardService.fileDetail(bno);
//		
//		try {
//			String fileUrl = fileVO.getFileUrl();
//			fileUrl += "/";
//			String savePath = fileUrl;
//			String fileName = fileVO.getFileName();
//			System.out.println("fileName:"+fileName);
//			
//			String oriFileName = fileVO.getFileOriName();
//			InputStream in = null;
//			OutputStream os = null;
//			File file = null;
//			boolean skip = false;
//			String client = "";
//			
//			try{
//				file = new File(savePath, fileName);
//				in = new FileInputStream(file);
//			}catch(FileNotFoundException fe){
//				skip = true;
//			}
//			
//			client = request.getHeader("User-Agent");
//			
//			response.reset();
//			response.setContentType("application/octet-stream");
//			response.setHeader("Content-Description", "JSP Generated Data");
//			
//			if(!skip){
//				if( client.indexOf("MSIE") != -1) {
//					response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+","\\ ") + "\"");
//				}else if(client.indexOf("Trident") != -1){
//					response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+","\\ ") + "\"");
//				}else{
//					response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1")+"\"");
//					response.setHeader("Content_Type", "application/octet-stream; charset-utf-8");
//				}
//				response.setHeader("Content-Length", ""+file.length());
//				os = response.getOutputStream();
//				byte b[] = new byte[(int) file.length()];
//				int leng=0;
//				while((leng=in.read(b))>0) {
//					os.write(b,0,leng);
//				}
//			}else {
//				response.setContentType("text/html; charset=UTF-8");
//				System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
//			}
//			in.close();
//			os.close();
//		}catch(Exception e){
//			System.out.println("error: "+ e.getMessage());
//		}
//	}

}
