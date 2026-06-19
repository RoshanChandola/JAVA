
const {
  Document, Packer, Paragraph, TextRun, Table, TableRow, TableCell,
  AlignmentType, HeadingLevel, BorderStyle, WidthType, ShadingType,
  LevelFormat, PageNumber, PageBreak, VerticalAlign
} = require('docx');
const fs = require('fs');

const border = { style: BorderStyle.SINGLE, size: 1, color: "AAAAAA" };
const borders = { top: border, bottom: border, left: border, right: border };
const headerBorder = { style: BorderStyle.SINGLE, size: 1, color: "2E75B6" };
const headerBorders = { top: headerBorder, bottom: headerBorder, left: headerBorder, right: headerBorder };

function heading1(text) {
  return new Paragraph({
    heading: HeadingLevel.HEADING_1,
    children: [new TextRun({ text, bold: true, size: 30, color: "1F3864" })],
    spacing: { before: 300, after: 150 },
    border: { bottom: { style: BorderStyle.SINGLE, size: 6, color: "2E75B6", space: 1 } }
  });
}

function heading2(text) {
  return new Paragraph({
    heading: HeadingLevel.HEADING_2,
    children: [new TextRun({ text, bold: true, size: 26, color: "2E75B6" })],
    spacing: { before: 200, after: 100 }
  });
}

function heading3(text) {
  return new Paragraph({
    children: [new TextRun({ text, bold: true, size: 22, color: "1F497D" })],
    spacing: { before: 150, after: 80 }
  });
}

function para(text, options = {}) {
  return new Paragraph({
    children: [new TextRun({ text, size: 22, ...options })],
    spacing: { before: 60, after: 60 }
  });
}

function bold(text) {
  return new Paragraph({
    children: [new TextRun({ text, bold: true, size: 22 })],
    spacing: { before: 60, after: 60 }
  });
}

function code(text) {
  return new Paragraph({
    children: [new TextRun({ text, font: "Courier New", size: 18, color: "333333" })],
    spacing: { before: 20, after: 20 },
    indent: { left: 720 },
    shading: { type: ShadingType.CLEAR, fill: "F2F2F2" }
  });
}

function bullet(text, ref = "bullets") {
  return new Paragraph({
    numbering: { reference: ref, level: 0 },
    children: [new TextRun({ text, size: 22 })],
    spacing: { before: 40, after: 40 }
  });
}

function mcqRow(num, question, answer, explanation) {
  return new TableRow({
    children: [
      new TableCell({
        borders, width: { size: 600, type: WidthType.DXA },
        margins: { top: 80, bottom: 80, left: 120, right: 120 },
        children: [new Paragraph({ children: [new TextRun({ text: `(${num})`, bold: true, size: 20 })] })]
      }),
      new TableCell({
        borders, width: { size: 3200, type: WidthType.DXA },
        margins: { top: 80, bottom: 80, left: 120, right: 120 },
        children: [new Paragraph({ children: [new TextRun({ text: question, size: 20 })] })]
      }),
      new TableCell({
        borders, width: { size: 1200, type: WidthType.DXA },
        shading: { type: ShadingType.CLEAR, fill: "E2EFDA" },
        margins: { top: 80, bottom: 80, left: 120, right: 120 },
        children: [new Paragraph({ children: [new TextRun({ text: answer, bold: true, size: 20, color: "375623" })] })]
      }),
      new TableCell({
        borders, width: { size: 4360, type: WidthType.DXA },
        margins: { top: 80, bottom: 80, left: 120, right: 120 },
        children: [new Paragraph({ children: [new TextRun({ text: explanation, size: 19, color: "444444" })] })]
      })
    ]
  });
}

const doc = new Document({
  numbering: {
    config: [
      {
        reference: "bullets",
        levels: [{
          level: 0, format: LevelFormat.BULLET, text: "\u2022", alignment: AlignmentType.LEFT,
          style: { paragraph: { indent: { left: 720, hanging: 360 } } }
        }]
      },
      {
        reference: "numbers",
        levels: [{
          level: 0, format: LevelFormat.DECIMAL, text: "%1.", alignment: AlignmentType.LEFT,
          style: { paragraph: { indent: { left: 720, hanging: 360 } } }
        }]
      }
    ]
  },
  styles: {
    default: { document: { run: { font: "Arial", size: 22 } } },
    paragraphStyles: [
      { id: "Heading1", name: "Heading 1", basedOn: "Normal", next: "Normal", quickFormat: true,
        run: { size: 30, bold: true, font: "Arial", color: "1F3864" },
        paragraph: { spacing: { before: 300, after: 150 }, outlineLevel: 0 } },
      { id: "Heading2", name: "Heading 2", basedOn: "Normal", next: "Normal", quickFormat: true,
        run: { size: 26, bold: true, font: "Arial", color: "2E75B6" },
        paragraph: { spacing: { before: 200, after: 100 }, outlineLevel: 1 } }
    ]
  },
  sections: [{
    properties: {
      page: {
        size: { width: 12240, height: 15840 },
        margin: { top: 1080, right: 1080, bottom: 1080, left: 1080 }
      }
    },
    children: [
      // ===================== TITLE =====================
      new Paragraph({
        children: [new TextRun({ text: "ADVANCE JAVA – MCA-202(DE2)", bold: true, size: 40, color: "1F3864" })],
        alignment: AlignmentType.CENTER,
        spacing: { before: 0, after: 100 }
      }),
      new Paragraph({
        children: [new TextRun({ text: "Detailed Answers | Examination 2023-24", size: 24, color: "2E75B6" })],
        alignment: AlignmentType.CENTER,
        spacing: { before: 0, after: 60 }
      }),
      new Paragraph({
        children: [new TextRun({ text: "MCA Second Semester | Max Marks: 60 | Time: 2.5 Hours", size: 22, color: "666666" })],
        alignment: AlignmentType.CENTER,
        spacing: { before: 0, after: 300 }
      }),

      // ===================== SECTION A =====================
      heading1("SECTION – A"),

      // ===== Q1 MCQ =====
      heading2("Q1. Multiple Choice Questions (1 mark each)"),
      para("All 12 MCQs with correct answers and explanations:"),
      new Paragraph({ spacing: { before: 100, after: 100 } }),

      new Table({
        width: { size: 9360, type: WidthType.DXA },
        columnWidths: [600, 3200, 1200, 4360],
        rows: [
          new TableRow({
            tableHeader: true,
            children: [
              new TableCell({
                borders: headerBorders, width: { size: 600, type: WidthType.DXA },
                shading: { type: ShadingType.CLEAR, fill: "1F3864" },
                margins: { top: 80, bottom: 80, left: 120, right: 120 },
                children: [new Paragraph({ children: [new TextRun({ text: "No.", bold: true, size: 20, color: "FFFFFF" })] })]
              }),
              new TableCell({
                borders: headerBorders, width: { size: 3200, type: WidthType.DXA },
                shading: { type: ShadingType.CLEAR, fill: "1F3864" },
                margins: { top: 80, bottom: 80, left: 120, right: 120 },
                children: [new Paragraph({ children: [new TextRun({ text: "Question", bold: true, size: 20, color: "FFFFFF" })] })]
              }),
              new TableCell({
                borders: headerBorders, width: { size: 1200, type: WidthType.DXA },
                shading: { type: ShadingType.CLEAR, fill: "1F3864" },
                margins: { top: 80, bottom: 80, left: 120, right: 120 },
                children: [new Paragraph({ children: [new TextRun({ text: "Answer", bold: true, size: 20, color: "FFFFFF" })] })]
              }),
              new TableCell({
                borders: headerBorders, width: { size: 4360, type: WidthType.DXA },
                shading: { type: ShadingType.CLEAR, fill: "1F3864" },
                margins: { top: 80, bottom: 80, left: 120, right: 120 },
                children: [new Paragraph({ children: [new TextRun({ text: "Explanation", bold: true, size: 20, color: "FFFFFF" })] })]
              })
            ]
          }),
          mcqRow("i","JSP Life Cycle Order","(c) Compilation, Initialization, Execution, Cleanup","The correct JSP life cycle is: Translation → Compilation → Initialization (_jspInit) → Execution (_jspService) → Cleanup (_jspDestroy)."),
          mcqRow("ii","Database independent query language","(a) HQL","HQL (Hibernate Query Language) is database independent. SQL is database-specific. AQL is not standard."),
          mcqRow("iii","Spring Boot packaging & distribution","(d) All of the above","Spring Boot apps can be packaged as JAR (executable), WAR (for servlet containers), or ZIP files for distribution."),
          mcqRow("iv","Not a type of Maven Repository","(d) Maven Local","Maven has 3 repository types: Local, Remote, and Central. 'Maven Local' is not a separate type — 'Local' itself is the correct term."),
          mcqRow("v","Spring Boot developed in","(a) April, 2014","Spring Boot 1.0 was officially released in April 2014 by Pivotal Software."),
          mcqRow("vi","JUnit is used for","(c) Unit Testing","JUnit is specifically a unit testing framework for the Java language, used to test individual methods/classes."),
          mcqRow("vii","JAR files needed for JUnit","(d) junit.jar and hamcrest-core.jar","Both junit.jar (core testing) and hamcrest-core.jar (matchers for assertions) are required on the classpath."),
          mcqRow("viii","Who developed Maven","(a) Jason Van Zyl","Maven was created by Jason Van Zyl and is currently maintained by the Apache Software Foundation."),
          mcqRow("ix","Not a core Hibernate interface","(b) Session Management","Core Hibernate interfaces are: Session, SessionFactory, Configuration, Transaction, Query, Criteria. 'Session Management' is not a formal interface name."),
          mcqRow("x","AJAX can be integrated with JSP","(a) True","Yes, AJAX can be easily integrated with JSP pages to make asynchronous server calls without page reload."),
          mcqRow("xi","AJAX is used for","(a) Asynchronous Web Application","AJAX = Asynchronous JavaScript and XML. It enables asynchronous communication with the server."),
          mcqRow("xii","ANT is Project Management Tool","(a) True","Apache ANT (Another Neat Tool) is a Java-based build/project management tool used to automate software build processes.")
        ]
      }),

      new Paragraph({ spacing: { before: 200, after: 200 } }),

      // ===== Q2 Short Answers =====
      heading2("Q2. Short Answer Questions (Attempt any 4, 3 marks each)"),

      // Q2(a)
      heading3("(a) JSP errorPage and isErrorPage Attributes of Page Directive"),
      para("JSP provides two attributes in the page directive to handle errors gracefully:"),
      bullet("errorPage: Specifies the URL of the error page to forward to when an exception occurs in the current page."),
      bullet("isErrorPage: Set to true on the page that acts as the error handler. This gives access to the exception object."),

      heading3("Program Example:"),
      para("File: main.jsp (the page that might throw an error)"),
      code('<%@ page errorPage="error.jsp" %>'),
      code("<%"),
      code("  int a = 10;"),
      code("  int b = 0;"),
      code("  int c = a / b;  // This causes ArithmeticException"),
      code("%>"),
      code("<html><body>"),
      code("  <h2>Result: <%= c %></h2>"),
      code("</body></html>"),

      new Paragraph({ spacing: { before: 100, after: 60 } }),
      para("File: error.jsp (the error handler page)"),
      code('<%@ page isErrorPage="true" %>'),
      code("<html><body>"),
      code('  <h2 style="color:red">An Error Occurred!</h2>'),
      code("  <p>Error Message: <%= exception.getMessage() %></p>"),
      code("  <p>Error Type: <%= exception.getClass().getName() %></p>"),
      code("</body></html>"),

      para("Key Points: When main.jsp throws ArithmeticException (divide by zero), it automatically forwards to error.jsp. The exception implicit object is only available when isErrorPage=\"true\"."),

      // Q2(b)
      heading3("(b) Web Application using JSP and AJAX"),
      para("AJAX with JSP allows updating parts of a web page without reloading it."),
      para("File: index.jsp"),
      code("<html><head>"),
      code("<script type='text/javascript'>"),
      code("function loadData() {"),
      code("  var xhr = new XMLHttpRequest();"),
      code("  xhr.open('GET', 'data.jsp', true);"),
      code("  xhr.onreadystatechange = function() {"),
      code("    if (xhr.readyState == 4 && xhr.status == 200) {"),
      code("      document.getElementById('result').innerHTML = xhr.responseText;"),
      code("    }"),
      code("  };"),
      code("  xhr.send();"),
      code("}"),
      code("</script></head>"),
      code("<body>"),
      code("  <h2>AJAX with JSP Example</h2>"),
      code("  <button onclick='loadData()'>Get Server Time</button>"),
      code("  <div id='result'></div>"),
      code("</body></html>"),

      para("File: data.jsp"),
      code("<%@ page import='java.util.Date' %>"),
      code("<%= 'Current Server Time: ' + new Date().toString() %>"),

      // Q2(c)
      heading3("(c) Why to Prefer AJAX in Web Application Development"),
      para("AJAX (Asynchronous JavaScript and XML) is preferred for the following reasons:"),
      bullet("Asynchronous Communication: Sends/receives data from server in the background without reloading the page, giving a smooth user experience."),
      bullet("Faster Response Time: Only specific parts of a page are updated, not the entire page, reducing bandwidth usage and time."),
      bullet("Better User Experience: No page flicker or full reload; applications feel like desktop apps (e.g., Gmail, Google Maps)."),
      bullet("Reduced Server Load: Sends only necessary data instead of full page requests, reducing server overhead."),
      bullet("Cross-browser Support: Works with all modern browsers using the XMLHttpRequest object."),
      bullet("Integration with JSON/XML: Easily works with JSON (preferred) and XML for structured data exchange."),
      bullet("Works with JSP, Servlet, Spring: AJAX can be integrated with any server-side technology."),
      para("Example use case: Form validation, live search, auto-suggestions, shopping cart updates."),

      // Q2(d)
      heading3("(d) XHTML: Working, Differences from HTML and XML"),
      para("XHTML (Extensible HyperText Markup Language) is a stricter, XML-based version of HTML."),
      bold("How XHTML Works:"),
      bullet("XHTML pages are parsed by XML parsers, ensuring strict structure."),
      bullet("All elements must be properly nested and closed."),
      bullet("It is served with MIME type application/xhtml+xml or text/html."),

      bold("Differences: XHTML vs HTML:"),
      new Table({
        width: { size: 9360, type: WidthType.DXA },
        columnWidths: [4680, 4680],
        rows: [
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "2E75B6" },
              margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "HTML", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "2E75B6" },
              margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "XHTML", bold: true, color: "FFFFFF", size: 20 })] })] })
          ]}),
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Tags can be uppercase or lowercase", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "All tags must be lowercase", size: 20 })] })] })
          ]}),
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Empty tags: <br>, <img>", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Must self-close: <br/>, <img/>", size: 20 })] })] })
          ]}),
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Attributes: value is optional", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Attributes must have quoted values", size: 20 })] })] })
          ]}),
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Not well-formed XML required", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 4680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Must be well-formed XML", size: 20 })] })] })
          ]})
        ]
      }),

      bold("Differences: XHTML vs XML:"),
      bullet("XML is used to store/transport data; XHTML is used to display data in browsers."),
      bullet("XML allows user-defined tags; XHTML uses predefined HTML tags."),
      bullet("XML is extensible; XHTML is a fixed vocabulary."),

      // Q2(e)
      heading3("(e) JUnit Framework Features"),
      para("JUnit is an open-source unit testing framework for Java. Key features:"),
      bullet("Annotations: @Test, @Before, @After, @BeforeClass, @AfterClass, @Ignore – simplify test setup and teardown."),
      bullet("Assertions: Methods like assertEquals(), assertTrue(), assertNull(), assertNotNull(), assertArrayEquals() to verify expected results."),
      bullet("Test Runner: Automatically discovers and runs all @Test methods. Can be integrated with Maven and IDEs."),
      bullet("Test Suites: Multiple test classes can be grouped into a test suite using @RunWith(Suite.class)."),
      bullet("Exception Testing: @Test(expected=Exception.class) verifies that the correct exception is thrown."),
      bullet("Timeout Testing: @Test(timeout=1000) ensures a test completes within a specified time in milliseconds."),
      bullet("Parameterized Tests: Run the same test with different input values using @RunWith(Parameterized.class)."),
      bullet("Integration with Build Tools: Works with Maven (Surefire plugin), Gradle, and Ant."),
      bullet("IDE Support: Full support in Eclipse, IntelliJ IDEA, and NetBeans for running and viewing test results."),
      bullet("Reports: Generates XML/HTML reports showing passed, failed, and skipped tests."),

      // ===================== SECTION B =====================
      new Paragraph({
        children: [new PageBreak()]
      }),
      heading1("SECTION – B"),

      // ===== Q3 =====
      heading2("Q3. Attempt any 2 of the following (6 marks each)"),

      // Q3(a)
      heading3("(a) XHTML Page to Store Student Details in MySQL Database"),
      para("We create an XHTML form page and a JSP to handle form submission and insert into MySQL."),

      bold("File: student.xhtml (Form Page)"),
      code('<?xml version="1.0" encoding="UTF-8"?>'),
      code('<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"'),
      code(' "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">'),
      code('<html xmlns="http://www.w3.org/1999/xhtml">'),
      code('<head><title>Student Registration</title></head>'),
      code('<body>'),
      code('  <h2>Student Registration Form</h2>'),
      code('  <form action="save.jsp" method="post">'),
      code('    Roll No: <input type="text" name="roll" /><br/>'),
      code('    Name: <input type="text" name="name" /><br/>'),
      code('    City: <input type="text" name="city" /><br/>'),
      code('    Phone: <input type="text" name="phone" /><br/>'),
      code('    Email: <input type="text" name="email" /><br/>'),
      code('    <input type="submit" value="Submit" />'),
      code('  </form>'),
      code('</body></html>'),

      bold("File: save.jsp (Database Insert Logic)"),
      code('<%@ page import="java.sql.*" %>'),
      code('<%'),
      code('  String roll = request.getParameter("roll");'),
      code('  String name = request.getParameter("name");'),
      code('  String city = request.getParameter("city");'),
      code('  String phone = request.getParameter("phone");'),
      code('  String email = request.getParameter("email");'),
      code(''),
      code('  Connection con = null;'),
      code('  PreparedStatement ps = null;'),
      code('  try {'),
      code('    Class.forName("com.mysql.cj.jdbc.Driver");'),
      code('    con = DriverManager.getConnection('),
      code('      "jdbc:mysql://localhost:3306/studentdb", "root", "password");'),
      code('    String sql = "INSERT INTO students(roll,name,city,phone,email)'),
      code('                  VALUES(?,?,?,?,?)";'),
      code('    ps = con.prepareStatement(sql);'),
      code('    ps.setString(1, roll);'),
      code('    ps.setString(2, name);'),
      code('    ps.setString(3, city);'),
      code('    ps.setString(4, phone);'),
      code('    ps.setString(5, email);'),
      code('    int i = ps.executeUpdate();'),
      code('    if(i > 0) {'),
      code('      out.println("<h3>Record Inserted Successfully!</h3>");'),
      code('    }'),
      code('  } catch(Exception e) {'),
      code('    out.println("Error: " + e.getMessage());'),
      code('  } finally {'),
      code('    if(ps != null) ps.close();'),
      code('    if(con != null) con.close();'),
      code('  }'),
      code('%>'),

      bold("MySQL Table Creation:"),
      code("CREATE TABLE students ("),
      code("  roll INT PRIMARY KEY,"),
      code("  name VARCHAR(50),"),
      code("  city VARCHAR(50),"),
      code("  phone VARCHAR(15),"),
      code("  email VARCHAR(50)"),
      code(");"),

      // Q3(b)
      heading3("(b) Architecture of Spring Framework"),
      para("The Spring Framework is a layered Java/JEE application framework. Its architecture consists of multiple modules grouped into layers:"),

      bold("1. Core Container (Foundation Layer):"),
      bullet("spring-core: Provides core utilities and IoC (Inversion of Control) container."),
      bullet("spring-beans: Implements BeanFactory for dependency injection."),
      bullet("spring-context: Extends beans; provides ApplicationContext, i18n, events."),
      bullet("spring-expression: Provides Spring Expression Language (SpEL)."),

      bold("2. Data Access/Integration Layer:"),
      bullet("spring-jdbc: Simplifies JDBC operations, removes boilerplate code."),
      bullet("spring-orm: Integration with ORM frameworks (Hibernate, JPA, JDO)."),
      bullet("spring-tx: Transaction management (programmatic and declarative)."),
      bullet("spring-jms: Java Message Service integration."),

      bold("3. Web Layer:"),
      bullet("spring-web: Basic web integration features."),
      bullet("spring-webmvc: Full MVC (Model-View-Controller) framework for web apps."),
      bullet("spring-webflux: Reactive web framework for non-blocking applications."),

      bold("4. AOP (Aspect-Oriented Programming):"),
      bullet("spring-aop: Enables cross-cutting concerns like logging, security, transaction."),
      bullet("spring-aspects: Integration with AspectJ."),

      bold("5. Test Layer:"),
      bullet("spring-test: Supports unit and integration testing with JUnit and TestNG."),

      bold("Diagram Description (Spring Architecture):"),
      para("[Test] ← sits above all layers"),
      para("[Web: WebMVC | WebFlux | WebSocket]"),
      para("[Data Access: JDBC | ORM | Transactions | JMS]"),
      para("[AOP | Aspects | Instrumentation]"),
      para("[Core Container: Core | Beans | Context | SpEL]"),
      para("All layers depend on the Core Container at the bottom."),

      bold("Key Concepts:"),
      bullet("IoC Container: Manages object creation and dependency injection automatically."),
      bullet("Dependency Injection (DI): Objects receive their dependencies from the container, not by creating them."),
      bullet("Loose Coupling: Components are independent; can be swapped easily."),
      bullet("POJO-based: Spring works with plain Java objects, no need to extend framework classes."),

      // Q3(c)
      heading3("(c) Web Application Using Hibernate Framework"),
      para("Hibernate is an ORM (Object Relational Mapping) framework that maps Java classes to database tables."),

      bold("Step 1: Add Dependencies (pom.xml if Maven)"),
      code("<dependency>"),
      code("  <groupId>org.hibernate</groupId>"),
      code("  <artifactId>hibernate-core</artifactId>"),
      code("  <version>5.6.15.Final</version>"),
      code("</dependency>"),
      code("<dependency>"),
      code("  <groupId>mysql</groupId>"),
      code("  <artifactId>mysql-connector-java</artifactId>"),
      code("  <version>8.0.33</version>"),
      code("</dependency>"),

      bold("Step 2: hibernate.cfg.xml (Configuration)"),
      code('<?xml version="1.0"?>'),
      code('<!DOCTYPE hibernate-configuration PUBLIC'),
      code(' "-//Hibernate/Hibernate Configuration DTD 3.0//EN"'),
      code(' "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">'),
      code('<hibernate-configuration>'),
      code('  <session-factory>'),
      code('    <property name="hibernate.connection.driver_class">'),
      code('      com.mysql.cj.jdbc.Driver</property>'),
      code('    <property name="hibernate.connection.url">'),
      code('      jdbc:mysql://localhost:3306/hibernatedb</property>'),
      code('    <property name="hibernate.connection.username">root</property>'),
      code('    <property name="hibernate.connection.password">password</property>'),
      code('    <property name="hibernate.dialect">'),
      code('      org.hibernate.dialect.MySQL8Dialect</property>'),
      code('    <property name="hibernate.hbm2ddl.auto">update</property>'),
      code('    <property name="show_sql">true</property>'),
      code('    <mapping class="com.example.Student"/>'),
      code('  </session-factory>'),
      code('</hibernate-configuration>'),

      bold("Step 3: Student.java (Entity / POJO)"),
      code("package com.example;"),
      code("import javax.persistence.*;"),
      code(""),
      code("@Entity"),
      code('@Table(name = "students")'),
      code("public class Student {"),
      code("  @Id"),
      code("  @GeneratedValue(strategy = GenerationType.IDENTITY)"),
      code("  private int id;"),
      code(""),
      code('  @Column(name = "name")'),
      code("  private String name;"),
      code(""),
      code('  @Column(name = "email")'),
      code("  private String email;"),
      code(""),
      code("  // Getters and Setters"),
      code("  public int getId() { return id; }"),
      code("  public void setId(int id) { this.id = id; }"),
      code("  public String getName() { return name; }"),
      code("  public void setName(String name) { this.name = name; }"),
      code("  public String getEmail() { return email; }"),
      code("  public void setEmail(String email) { this.email = email; }"),
      code("}"),

      bold("Step 4: SaveStudent.jsp (Save to DB using Hibernate)"),
      code('<%@ page import="org.hibernate.*,org.hibernate.cfg.*,com.example.*" %>'),
      code("<%"),
      code("  String name = request.getParameter('name');"),
      code("  String email = request.getParameter('email');"),
      code(""),
      code("  Configuration cfg = new Configuration().configure();"),
      code("  SessionFactory sf = cfg.buildSessionFactory();"),
      code("  Session session = sf.openSession();"),
      code("  Transaction tx = session.beginTransaction();"),
      code(""),
      code("  Student s = new Student();"),
      code("  s.setName(name);"),
      code("  s.setEmail(email);"),
      code("  session.save(s);"),
      code("  tx.commit();"),
      code("  session.close();"),
      code('  out.println("<h3>Student Saved with Hibernate!</h3>");'),
      code("%>"),

      // ===== Q4 =====
      new Paragraph({ children: [new PageBreak()] }),
      heading2("Q4. Attempt any 2 of the following (6 marks each)"),

      // Q4(a)
      heading3("(a) JSF Popularity and Life Cycle"),
      bold("Why JSF (JavaServer Faces) is Popular:"),
      bullet("Component-Based: JSF uses reusable UI components (forms, buttons, tables) that abstract away HTML/JS complexity."),
      bullet("MVC Architecture: Cleanly separates Model (Managed Beans), View (XHTML pages), and Controller (FacesServlet)."),
      bullet("Built-in Validation: Provides validators and converters for form inputs without extra coding."),
      bullet("Event Handling: Supports action and value change listeners at the server side."),
      bullet("Navigation Rules: Declarative navigation using faces-config.xml or annotations (@NavigationCase)."),
      bullet("Rich Component Libraries: Compatible with PrimeFaces, RichFaces, ICEFaces for advanced UI."),
      bullet("Standard Java EE Spec: Part of Java EE specification, ensuring portability across application servers."),
      bullet("Ajax Support: Built-in Ajax via <f:ajax> tag without writing JavaScript."),
      bullet("Internationalization: Easy i18n support for multilingual applications."),

      bold("JSF Life Cycle (6 Phases):"),
      new Table({
        width: { size: 9360, type: WidthType.DXA },
        columnWidths: [600, 2500, 6260],
        rows: [
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 600, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Phase", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 2500, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Name", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 6260, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Description", bold: true, color: "FFFFFF", size: 20 })] })] })
          ]}),
          ...[
            ["1","Restore View","Creates or restores the component tree (view) from the previous request. On first request, creates empty view."],
            ["2","Apply Request Values","Each component reads its value from the HTTP request parameters."],
            ["3","Process Validations","Runs validators (required, range, custom) on submitted values. Errors cause jump to Render Response."],
            ["4","Update Model Values","Pushes validated values into the managed bean properties (model)."],
            ["5","Invoke Application","Executes action methods (event listeners) defined in managed beans."],
            ["6","Render Response","Encodes the response HTML and sends it to the client browser."]
          ].map(([num, name, desc]) => new TableRow({ children: [
            new TableCell({ borders, width: { size: 600, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: num, bold: true, size: 20 })] })] }),
            new TableCell({ borders, width: { size: 2500, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: name, bold: true, size: 20 })] })] }),
            new TableCell({ borders, width: { size: 6260, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: desc, size: 20 })] })] })
          ]}))
        ]
      }),

      bold("Example: JSF Managed Bean"),
      code("import javax.faces.bean.*;"),
      code("@ManagedBean"),
      code("@RequestScoped"),
      code("public class HelloBean {"),
      code("  private String name;"),
      code("  public String getName() { return name; }"),
      code("  public void setName(String name) { this.name = name; }"),
      code("  public String greet() {"),
      code('    return "Hello, " + name + "!";'),
      code("  }"),
      code("}"),

      bold("Example: JSF XHTML Page"),
      code('<?xml version="1.0" encoding="UTF-8"?>'),
      code('<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"'),
      code(' "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">'),
      code('<html xmlns="http://www.w3.org/1999/xhtml"'),
      code('      xmlns:h="http://xmlns.jcp.org/jsf/html">'),
      code('<h:head><title>JSF Hello</title></h:head>'),
      code('<h:body>'),
      code('  <h:form>'),
      code('    <h:inputText value="#{helloBean.name}" />'),
      code('    <h:commandButton value="Greet" action="#{helloBean.greet}" />'),
      code('  </h:form>'),
      code('</h:body></html>'),

      // Q4(b)
      heading3("(b) Spring Framework – Welcome Message Web Application"),
      para("We create a simple Spring MVC web application to print a welcome message."),

      bold("Step 1: pom.xml (Dependencies)"),
      code("<dependency>"),
      code("  <groupId>org.springframework</groupId>"),
      code("  <artifactId>spring-webmvc</artifactId>"),
      code("  <version>5.3.29</version>"),
      code("</dependency>"),

      bold("Step 2: web.xml (Deployment Descriptor)"),
      code('<?xml version="1.0" encoding="UTF-8"?>'),
      code('<web-app>'),
      code('  <servlet>'),
      code('    <servlet-name>dispatcher</servlet-name>'),
      code('    <servlet-class>'),
      code('      org.springframework.web.servlet.DispatcherServlet'),
      code('    </servlet-class>'),
      code('    <load-on-startup>1</load-on-startup>'),
      code('  </servlet>'),
      code('  <servlet-mapping>'),
      code('    <servlet-name>dispatcher</servlet-name>'),
      code('    <url-pattern>/</url-pattern>'),
      code('  </servlet-mapping>'),
      code('</web-app>'),

      bold("Step 3: dispatcher-servlet.xml (Spring Configuration)"),
      code('<beans xmlns="http://www.springframework.org/schema/beans"'),
      code('  xmlns:context="http://www.springframework.org/schema/context"'),
      code('  xmlns:mvc="http://www.springframework.org/schema/mvc">'),
      code('  <context:component-scan base-package="com.example"/>'),
      code('  <mvc:annotation-driven/>'),
      code('  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">'),
      code('    <property name="prefix" value="/WEB-INF/views/"/>'),
      code('    <property name="suffix" value=".jsp"/>'),
      code('  </bean>'),
      code('</beans>'),

      bold("Step 4: HelloController.java"),
      code("package com.example;"),
      code("import org.springframework.stereotype.*;"),
      code("import org.springframework.web.bind.annotation.*;"),
      code("import org.springframework.ui.Model;"),
      code(""),
      code("@Controller"),
      code("public class HelloController {"),
      code('  @RequestMapping("/welcome")'),
      code("  public String welcome(Model model) {"),
      code('    model.addAttribute("message", "Welcome to Spring MVC!");'),
      code('    return "welcome";'),
      code("  }"),
      code("}"),

      bold("Step 5: /WEB-INF/views/welcome.jsp"),
      code("<html><body>"),
      code('  <h2>${message}</h2>'),
      code("</body></html>"),

      para("Output: When you visit http://localhost:8080/yourapp/welcome, it displays: 'Welcome to Spring MVC!'"),

      // Q4(c)
      heading3("(c) JSP Scriptlet Tags – Why to Prefer and Program with All Tags"),
      bold("Why Prefer Scriptlet Tags:"),
      bullet("Scriptlet tags allow embedding Java code directly inside HTML/JSP pages."),
      bullet("Useful for dynamic content generation, loops, conditions, and data processing."),
      bullet("Quickly prototype server-side logic without separate Java classes."),
      bullet("Access all JSP implicit objects (request, response, session, out, etc.)."),

      bold("Types of JSP Scripting Tags:"),
      new Table({
        width: { size: 9360, type: WidthType.DXA },
        columnWidths: [2500, 2000, 4860],
        rows: [
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 2500, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Tag", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 2000, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Syntax", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 4860, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Purpose", bold: true, color: "FFFFFF", size: 20 })] })] })
          ]}),
          ...[
            ["Scriptlet Tag","<% ... %>","Embeds Java code that executes during request processing."],
            ["Expression Tag","<%= ... %>","Outputs the value of a Java expression directly to the page."],
            ["Declaration Tag","<%! ... %>","Declares methods or instance variables available to the whole page."],
            ["Directive Tag","<%@ ... %>","Gives instructions to the JSP engine (page, include, taglib)."],
            ["Comment Tag","<%-- ... --%>","JSP comment, not sent to browser (unlike HTML <!-- -->)."]
          ].map(([tag, syn, purpose]) => new TableRow({ children: [
            new TableCell({ borders, width: { size: 2500, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: tag, bold: true, size: 20 })] })] }),
            new TableCell({ borders, width: { size: 2000, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: syn, font: "Courier New", size: 18 })] })] }),
            new TableCell({ borders, width: { size: 4860, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: purpose, size: 20 })] })] })
          ]}))
        ]
      }),

      bold("Complete Program Using All Scriptlet Tags:"),
      code("<%-- JSP Comment: This is an advanced JSP example --%>"),
      code("<%@ page language='java' contentType='text/html' pageEncoding='UTF-8' %>"),
      code("<%@ page import='java.util.Date' %>"),
      code(""),
      code("<%!"),
      code("  // Declaration tag: Instance variable and method"),
      code("  int visitCount = 0;"),
      code("  String getGreeting(String name) {"),
      code('    return "Hello, " + name + "! Welcome to JSP.";'),
      code("  }"),
      code("%>"),
      code(""),
      code("<html><body>"),
      code("  <h2>JSP Scriptlet Tags Demo</h2>"),
      code(""),
      code("  <%"),
      code("    // Scriptlet tag: Java code block"),
      code("    visitCount++;"),
      code("    String user = request.getParameter('user');"),
      code("    if(user == null) user = 'Guest';"),
      code("  %>"),
      code(""),
      code("  <!-- Expression tag to display value -->"),
      code("  <p>Greeting: <%= getGreeting(user) %></p>"),
      code("  <p>Visit Count: <%= visitCount %></p>"),
      code("  <p>Server Time: <%= new Date() %></p>"),
      code(""),
      code("  <%"),
      code("    // Scriptlet: Loop"),
      code("    for(int i = 1; i <= 5; i++) {"),
      code("  %>"),
      code("    <p>Item Number: <%= i %></p>"),
      code("  <%"),
      code("    }"),
      code("  %>"),
      code("</body></html>"),

      // ===== Q5 =====
      new Paragraph({ children: [new PageBreak()] }),
      heading2("Q5. Attempt any 2 of the following (6 marks each)"),

      // Q5(a)
      heading3("(a) Web Application to Fetch Employee Data from MySQL using JSP"),
      para("We create a JSP page to fetch and display employee records from MySQL."),

      bold("Step 1: Create MySQL Table"),
      code("CREATE TABLE employee ("),
      code("  Emp_id INT PRIMARY KEY AUTO_INCREMENT,"),
      code("  Emp_Name VARCHAR(12),"),
      code("  Emp_Address VARCHAR(23),"),
      code("  Email VARCHAR(23)"),
      code(");"),
      code(""),
      code("-- Insert sample data"),
      code("INSERT INTO employee VALUES(NULL, 'Rahul', 'Delhi', 'rahul@mail.com');"),
      code("INSERT INTO employee VALUES(NULL, 'Priya', 'Mumbai', 'priya@mail.com');"),
      code("INSERT INTO employee VALUES(NULL, 'Amit', 'Pune', 'amit@mail.com');"),

      bold("Step 2: fetchEmployee.jsp"),
      code("<%@ page import='java.sql.*' %>"),
      code("<html>"),
      code("<head>"),
      code("  <title>Employee Records</title>"),
      code("  <style>"),
      code("    table { border-collapse: collapse; width: 80%; }"),
      code("    th, td { border: 1px solid #333; padding: 8px; text-align: left; }"),
      code("    th { background-color: #2E75B6; color: white; }"),
      code("    tr:nth-child(even) { background-color: #f2f2f2; }"),
      code("  </style>"),
      code("</head>"),
      code("<body>"),
      code("  <h2>Employee Records</h2>"),
      code("  <table>"),
      code("    <tr>"),
      code("      <th>Emp ID</th><th>Name</th><th>Address</th><th>Email</th>"),
      code("    </tr>"),
      code(""),
      code("<%"),
      code("  Connection con = null;"),
      code("  Statement stmt = null;"),
      code("  ResultSet rs = null;"),
      code("  try {"),
      code("    Class.forName('com.mysql.cj.jdbc.Driver');"),
      code("    con = DriverManager.getConnection("),
      code("      'jdbc:mysql://localhost:3306/empdb', 'root', 'password');"),
      code("    stmt = con.createStatement();"),
      code("    rs = stmt.executeQuery('SELECT * FROM employee');"),
      code("    while(rs.next()) {"),
      code("%>"),
      code("    <tr>"),
      code("      <td><%= rs.getInt('Emp_id') %></td>"),
      code("      <td><%= rs.getString('Emp_Name') %></td>"),
      code("      <td><%= rs.getString('Emp_Address') %></td>"),
      code("      <td><%= rs.getString('Email') %></td>"),
      code("    </tr>"),
      code("<%"),
      code("    }  // end while"),
      code("  } catch(Exception e) {"),
      code("    out.println('<tr><td colspan=4>Error: ' + e.getMessage() + '</td></tr>');"),
      code("  } finally {"),
      code("    if(rs != null) rs.close();"),
      code("    if(stmt != null) stmt.close();"),
      code("    if(con != null) con.close();"),
      code("  }"),
      code("%>"),
      code("  </table>"),
      code("</body></html>"),

      // Q5(b)
      heading3("(b) Java Frameworks and Key Features of Spring Boot"),
      bold("Popular Java Frameworks:"),
      new Table({
        width: { size: 9360, type: WidthType.DXA },
        columnWidths: [2000, 3680, 3680],
        rows: [
          new TableRow({ children: [
            new TableCell({ borders, width: { size: 2000, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Framework", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 3680, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Purpose", bold: true, color: "FFFFFF", size: 20 })] })] }),
            new TableCell({ borders, width: { size: 3680, type: WidthType.DXA }, shading: { type: ShadingType.CLEAR, fill: "1F3864" }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: "Key Use", bold: true, color: "FFFFFF", size: 20 })] })] })
          ]}),
          ...[
            ["Spring MVC","Web application framework based on MVC pattern","Building enterprise web applications"],
            ["Spring Boot","Simplifies Spring app setup with auto-configuration","Microservices, REST APIs"],
            ["Hibernate","ORM framework for database operations","Replacing JDBC boilerplate"],
            ["JSF (JavaServer Faces)","Component-based UI framework for Java EE","Rich web UI development"],
            ["Struts 2","MVC framework by Apache","Web apps (older enterprise systems)"],
            ["Maven / Gradle","Build and dependency management tools","Project lifecycle management"],
            ["JUnit","Unit testing framework","Automated testing of Java code"]
          ].map(([fw, purpose, use]) => new TableRow({ children: [
            new TableCell({ borders, width: { size: 2000, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: fw, bold: true, size: 20 })] })] }),
            new TableCell({ borders, width: { size: 3680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: purpose, size: 20 })] })] }),
            new TableCell({ borders, width: { size: 3680, type: WidthType.DXA }, margins: { top: 80, bottom: 80, left: 120, right: 120 },
              children: [new Paragraph({ children: [new TextRun({ text: use, size: 20 })] })] })
          ]}))
        ]
      }),

      bold("Key Features of Spring Boot:"),
      bullet("Auto-Configuration: Automatically configures Spring and third-party libraries based on dependencies in the classpath. No manual XML configuration needed."),
      bullet("Embedded Server: Comes with embedded Tomcat, Jetty, or Undertow. No need to deploy WAR files to an external server."),
      bullet("Spring Initializr: Web-based project generator (start.spring.io) to quickly create Spring Boot projects with chosen dependencies."),
      bullet("Starter Dependencies: Pre-packaged dependencies like spring-boot-starter-web, spring-boot-starter-data-jpa, spring-boot-starter-security simplify POM configuration."),
      bullet("Production-Ready Features: Actuator provides endpoints for health checks, metrics, and monitoring (/actuator/health)."),
      bullet("Standalone Applications: Spring Boot apps can run as standalone JAR files using java -jar command."),
      bullet("Spring Boot DevTools: Supports hot reloading – application restarts automatically when code changes."),
      bullet("REST API Support: Makes it extremely easy to create RESTful APIs using @RestController and @RequestMapping."),
      bullet("Profile-Based Configuration: Use application.properties or application.yml with profiles (dev, prod) for environment-specific settings."),
      bullet("Spring Security Integration: Built-in support for authentication and authorization."),
      bullet("Microservices Ready: Ideal for building microservices that communicate via REST or messaging queues."),

      bold("Simple Spring Boot Example:"),
      code("@SpringBootApplication"),
      code("public class MyApp {"),
      code("  public static void main(String[] args) {"),
      code("    SpringApplication.run(MyApp.class, args);"),
      code("  }"),
      code("}"),
      code(""),
      code("@RestController"),
      code("public class HelloController {"),
      code('  @GetMapping("/hello")'),
      code("  public String hello() {"),
      code('    return "Hello from Spring Boot!";'),
      code("  }"),
      code("}"),

      // Q5(c)
      heading3("(c) Web Application using AJAX to Print Table of an Input Number"),
      para("We create a web app where user enters a number and AJAX fetches and displays the multiplication table without page reload."),

      bold("File: index.jsp (Main Page)"),
      code("<html>"),
      code("<head>"),
      code("  <title>Multiplication Table using AJAX</title>"),
      code("  <style>"),
      code("    body { font-family: Arial; padding: 30px; }"),
      code("    table { border-collapse: collapse; margin-top: 15px; }"),
      code("    td { border: 1px solid #555; padding: 10px 20px; }"),
      code("    th { background: #2E75B6; color: white; padding: 10px 20px; }"),
      code("  </style>"),
      code("  <script>"),
      code("  function getTable() {"),
      code("    var num = document.getElementById('num').value;"),
      code("    if(num == '' || isNaN(num)) {"),
      code("      alert('Please enter a valid number!');"),
      code("      return;"),
      code("    }"),
      code("    var xhr = new XMLHttpRequest();"),
      code("    xhr.open('GET', 'table.jsp?num=' + num, true);"),
      code("    xhr.onreadystatechange = function() {"),
      code("      if(xhr.readyState == 4 && xhr.status == 200) {"),
      code("        document.getElementById('result').innerHTML = xhr.responseText;"),
      code("      }"),
      code("    };"),
      code("    xhr.send();"),
      code("  }"),
      code("  </script>"),
      code("</head>"),
      code("<body>"),
      code("  <h2>Multiplication Table using AJAX &amp; JSP</h2>"),
      code("  <label>Enter Number:</label>"),
      code("  <input type='text' id='num' placeholder='e.g. 5'/>"),
      code("  <button onclick='getTable()'>Generate Table</button>"),
      code("  <br/><br/>"),
      code("  <div id='result'></div>"),
      code("</body></html>"),

      bold("File: table.jsp (Server-side logic called by AJAX)"),
      code("<%@ page contentType='text/html' pageEncoding='UTF-8' %>"),
      code("<%"),
      code("  String numStr = request.getParameter('num');"),
      code("  int num = Integer.parseInt(numStr);"),
      code("%>"),
      code("<table>"),
      code("  <tr><th colspan='3'>Table of <%= num %></th></tr>"),
      code("  <tr><th>Expression</th><th>x</th><th>Result</th></tr>"),
      code("  <%"),
      code("    for(int i = 1; i <= 10; i++) {"),
      code("  %>"),
      code("  <tr>"),
      code("    <td><%= num %> x <%= i %></td>"),
      code("    <td>=</td>"),
      code("    <td><%= num * i %></td>"),
      code("  </tr>"),
      code("  <%"),
      code("    }"),
      code("  %>"),
      code("</table>"),

      para("How it Works:"),
      bullet("User enters a number (e.g., 5) and clicks 'Generate Table'."),
      bullet("JavaScript creates an XMLHttpRequest and sends a GET request to table.jsp?num=5."),
      bullet("table.jsp generates the multiplication table HTML and sends it back as response."),
      bullet("AJAX receives the HTML and injects it into the <div id='result'> without reloading the page."),

      new Paragraph({ spacing: { before: 300, after: 100 } }),
      new Paragraph({
        children: [new TextRun({ text: "— End of Answer Sheet —", bold: true, size: 22, color: "666666" })],
        alignment: AlignmentType.CENTER
      })
    ]
  }]
});

Packer.toBuffer(doc).then(buffer => {
  fs.writeFileSync('/home/claude/AdvanceJava_Answers.docx', buffer);
  console.log('Document created successfully!');
}).catch(err => {
  console.error('Error:', err);
});