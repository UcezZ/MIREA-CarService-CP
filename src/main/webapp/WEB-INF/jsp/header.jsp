<div class="header">
  <div class="logo-caption vertical-centerer-wrapper">
      <span>uCarService</span>
  </div>
  <div class="hdr-caption vertical-centerer-wrapper">
    <span>Главная</span>
  </div>
  <div class="auth-block">
    <sec:authorize access="isAuthenticated()">
    <div class="profile-icon vertical-centerer-wrapper"></div>
    <div class="vertical-centerer-wrapper">
      <span class="profile">${pageContext.request.userPrincipal.name}</span>
    </div>
    <div class="vertical-centerer-wrapper">
      <a href="/logout">Выйти</a>
    </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
    <div class="vertical-centerer-wrapper">
      <a href="/login">Войти</a>
    </div>
    <div class="vertical-centerer-wrapper">
      <a href="/register">Регистрация</a>
    </div>
    </sec:authorize>
    </div>
  </div>
<div class="header">
        <div class="logo-caption vertical-centerer-wrapper">
            <span>uCarService</span>
        </div>
        <div class="auth-block">
            <sec:authorize access="isAuthenticated()">
                <div class="profile-icon vertical-centerer-wrapper"></div>
                <div class="vertical-centerer-wrapper">
                    <span class="profile"><a href="profile.html">${pageContext.request.userPrincipal.name}</a></span>
                </div>
            </sec:authorize>
            <div class="auth-buttons">
                <sec:authorize access="!isAuthenticated()">
                    <div class="vertical-centerer-wrapper">
                        <a href="/login">Войти</a>
                    </div>
                    <div class="vertical-centerer-wrapper">
                        <a href="/register">Регистрация</a>
                    </div>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div class="vertical-centerer-wrapper">
                        <a href="/logout">Выйти</a>
                    </div>
                </sec:authorize>
            </div>
        </div>
    </div>