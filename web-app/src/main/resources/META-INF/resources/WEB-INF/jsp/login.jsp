<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

        <div class="container">
            <h1>Login</h1>
            <p>Welcome to the login page..</p>
            <p>${errorMessage}</p>
            <form method="POST">
                Name:<input type="text" name="name">
                Password: <input type="password" name="password">
                <input type="submit">
            </form>
        </div>
<%@ include file="common/footer.jspf"%>
