<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>
    </head>

    <body>
      <sec:authorize access="isAuthenticated()">
        <% response.sendRedirect("/"); %>
      </sec:authorize>
      <div>
        <form class="form-signin" method="post" action="/login">
          <h2 class="form-signin-heading">Please sign in</h2>
          <p>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required=""
              autofocus="">
          </p>
          <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password"
              required="">
          </p>
          <input name="_csrf" type="hidden" value="10a216ec-6bdc-4a7d-9308-e1de6d6453f9">
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
      </div>

    </body>

    </html>