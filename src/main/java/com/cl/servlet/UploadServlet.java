package com.cl.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/file/upload")
public class UploadServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.getSession().setAttribute("user", "root");
        String fileName = request.getParameter("fileName");
        System.out.println("fileName = " + fileName);

        ServletContext context = request.getServletContext();
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        String contextPath = context.getContextPath();
        System.out.println("contextPath = " + contextPath);
//        requestURI = requestURI.substring(requestURI.lastIndexOf("="));

        String filePath = context.getRealPath(fileName);
        System.out.println("filePath = " + filePath);
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        int len = 0;
        byte[] buffer = new byte[1024];
        String line;
        StringBuilder builder = new StringBuilder();

        String s = Files.readString(Paths.get(filePath));
        while((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }

//        String content = os.toString("UTF-8");

        String content = builder.toString();
        System.out.println("content: "+ s);
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        writer.write("<html><head><meta charset=\"UTF-8\"></head><body>");
        writer.write("<h1>Uploaded Files</h1>");
        writer.write("<pre><code>");
        writer.write(s);
        writer.write("</code></pre>");
        writer.write("</body></html>");
        writer.flush();
    }

    //   Get-Content -Path "$env:USERPROFILE\.ssh\id_rsa.pub"
}
