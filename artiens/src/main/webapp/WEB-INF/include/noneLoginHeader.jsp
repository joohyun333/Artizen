<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header
============================================= -->
  <div id="header-wrap">
    <div class="container">
      <div class="header-row">

          <!-- Logo
          ============================================= -->
          <div id="logo">
            <a href="<c:url value='/'/>" class="standard-logo" data-dark-logo="<c:url value="/images/logo_new/logo_D.png"/>" style="height: 50px;">
              <img src="<c:url value="/images/logo_new/logo_D.png"/>" alt="Artizen Logo">
            </a>
          </div><!-- #logo end -->

          <div class="header-misc">
            <!-- Top Search
        ============================================= -->
            <div id="top-search" class="header-misc-icon">
              <a href="#" id="top-search-trigger">
                <i class="icon-line-search"></i>
                <i class="icon-line-cross"></i>
              </a>
            </div><!-- #top-search end -->

            <!-- 유저 로그인 정보-->
            <div id="top-login-in" class="header-misc-icon d-none d-sm-block">
              <a href="<c:url value='/login'/>">
                <i class="icon-line-log-in">
					
                </i>
              </a>
            </div>
          </div>

          <div id="primary-menu-trigger">
            <svg class="svg-trigger" viewBox="0 0 100 100">
              <path d="m 30,33 h 40 c 3.722839,0 7.5,3.126468 7.5,8.578427 0,5.451959 -2.727029,8.421573 -7.5,8.421573 h -20"></path>
              <path d="m 30,50 h 40"></path>
              <path d="m 70,67 h -40 c 0,0 -7.5,-0.802118 -7.5,-8.365747 0,-7.563629 7.5,-8.634253 7.5,-8.634253 h 20"></path>
            </svg>
          </div>

          <!-- Primary Navigation
          ============================================= -->
          <nav class="primary-menu">

            <ul class="menu-container">
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="<c:url value='/'/>">
                  <div>작 품</div>
                </a>
                <ul class="sub-menu-container bg-light" >
                  <li class="menu-item ">
                    <a class="menu-link" href="<c:url value='/artwork/ink'/>">
                      <div>수묵화</div>
                    </a>
                  </li>
                  <li class="menu-item ">
                    <a class="menu-link" href="<c:url value='/artwork/color'/>">
                      <div>채색화</div>
                    </a>
                  </li>
                  <li class="menu-item ">
                    <a class="menu-link" href="<c:url value='/artwork/landscape'/>">
                      <div>풍경화</div>
                    </a>
                  </li>
                  <li class="menu-item ">
                    <a class="menu-link" href="<c:url value='/artwork/figure'/>">
                      <div>인물화</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="<c:url value='/artwork/abstract'/>">
                      <div>추상화</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="<c:url value='/artwork/still'/>">
                      <div>정물화</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="<c:url value='/artwork/pop'/>">
                      <div>팝아트</div>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="<c:url value='/collaboration/main'/>">
                  <div>콜라보레이션</div>
                </a>
              </li>
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="<c:url value='/patron'/>">
                  <div>후원하기</div>
                </a>
                <ul class="sub-menu-container bg-light">
                  <li class="menu-item">
                    <a class="menu-link" href="<c:url value='/patron'/>">
                      <div>후원이란</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="<c:url value='/patron/creator'/>">
                      <div>크리에이터</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="<c:url value='/patron/reward'/>">
                      <div>리워드</div>
                    </a>
                  </li>
                </ul>
              </li>
             </ul>
          </nav><!-- #primary-menu end -->

        <form class="top-search-form" action="" method="get">
          <input type="text" name="q" class="form-control" value="" placeholder="Type &amp; Hit Enter.." autocomplete="off">
        </form>

      </div>
    </div>
  </div>
<!-- #header end -->
