/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-09-18 16:49:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("jar:file:/E:/PBL3/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PBL3/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/common/taglib.jsp", Long.valueOf(1718253315461L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1712941234455L));
    _jspx_dependants.put("jar:file:/E:/PBL3/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PBL3/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("jar:file:/E:/PBL3/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PBL3/WEB-INF/lib/sitemesh-2.4.2.jar!/META-INF/sitemesh-decorator.tld", Long.valueOf(1123653092000L));
    _jspx_dependants.put("/WEB-INF/lib/sitemesh-2.4.2.jar", Long.valueOf(1712941234580L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Job Portal</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"slider-area \">\r\n");
      out.write("		<!-- Mobile Menu -->\r\n");
      out.write("		<div class=\"slider-active\">\r\n");
      out.write("			<div class=\"single-slider slider-height d-flex align-items-center\"\r\n");
      out.write("				data-background=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("				<div class=\"container\">\r\n");
      out.write("					<div class=\"row\">\r\n");
      out.write("						<div class=\"col-xl-6 col-lg-9 col-md-10\">\r\n");
      out.write("							<div class=\"hero__caption\">\r\n");
      out.write("								<h1>Find the most exciting startup jobs</h1>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<!-- Search Box -->\r\n");
      out.write("					<div class=\"row\">\r\n");
      out.write("						<div class=\"col-xl-8\"></div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- slider Area End-->\r\n");
      out.write("	<!-- Our Services Start -->\r\n");
      out.write("	<div class=\"our-services section-pad-t30\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<!-- Section Tittle -->\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-lg-12\">\r\n");
      out.write("					<div class=\"section-tittle text-center\">\r\n");
      out.write("						<span>FEATURED TOURS Packages</span>\r\n");
      out.write("						<h2>Browse Top Categories</h2>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"row d-flex justify-contnet-center\">\r\n");
      out.write("				<div class=\"col-xl-3 col-lg-3 col-md-4 col-sm-6\">\r\n");
      out.write("					<div class=\"single-services text-center mb-30\">\r\n");
      out.write("						<div class=\"services-ion\">\r\n");
      out.write("							<span class=\"flaticon-tour\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"services-cap\">\r\n");
      out.write("							<h5>\r\n");
      out.write("								<a href=\"job_listing.html\">Design &amp; Creative</a>\r\n");
      out.write("							</h5>\r\n");
      out.write("							<span>(653)</span>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-xl-3 col-lg-3 col-md-4 col-sm-6\">\r\n");
      out.write("					<div class=\"single-services text-center mb-30\">\r\n");
      out.write("						<div class=\"services-ion\">\r\n");
      out.write("							<span class=\"flaticon-cms\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"services-cap\">\r\n");
      out.write("							<h5>\r\n");
      out.write("								<a href=\"job_listing.html\">Design &amp; Development</a>\r\n");
      out.write("							</h5>\r\n");
      out.write("							<span>(658)</span>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-xl-3 col-lg-3 col-md-4 col-sm-6\">\r\n");
      out.write("					<div class=\"single-services text-center mb-30\">\r\n");
      out.write("						<div class=\"services-ion\">\r\n");
      out.write("							<span class=\"flaticon-report\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"services-cap\">\r\n");
      out.write("							<h5>\r\n");
      out.write("								<a href=\"job_listing.html\">Sales &amp; Marketing</a>\r\n");
      out.write("							</h5>\r\n");
      out.write("							<span>(658)</span>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				<div class=\"col-xl-3 col-lg-3 col-md-4 col-sm-6\">\r\n");
      out.write("					<div class=\"single-services text-center mb-30\">\r\n");
      out.write("						<div class=\"services-ion\">\r\n");
      out.write("							<span class=\"flaticon-high-tech\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"services-cap\">\r\n");
      out.write("							<h5>\r\n");
      out.write("								<a href=\"job_listing.html\">Information Technology</a>\r\n");
      out.write("							</h5>\r\n");
      out.write("							<span>(658)</span>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- How  Apply Process Start-->\r\n");
      out.write("	<div class=\"apply-process-area apply-bg pt-150 pb-150\"\r\n");
      out.write("		data-background=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<!-- Section Tittle -->\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-lg-12\">\r\n");
      out.write("					<div class=\"section-tittle white-text text-center\">\r\n");
      out.write("						<span>Apply process</span>\r\n");
      out.write("						<h2>How it works</h2>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- Apply Process Caption -->\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-lg-4 col-md-6\">\r\n");
      out.write("					<div class=\"single-process text-center mb-30\">\r\n");
      out.write("						<div class=\"process-ion\">\r\n");
      out.write("							<span class=\"flaticon-search\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"process-cap\">\r\n");
      out.write("							<h5>1. Search a job</h5>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-lg-4 col-md-6\">\r\n");
      out.write("					<div class=\"single-process text-center mb-30\">\r\n");
      out.write("						<div class=\"process-ion\">\r\n");
      out.write("							<span class=\"flaticon-curriculum-vitae\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"process-cap\">\r\n");
      out.write("							<h5>2. Apply for job</h5>\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-lg-4 col-md-6\">\r\n");
      out.write("					<div class=\"single-process text-center mb-30\">\r\n");
      out.write("						<div class=\"process-ion\">\r\n");
      out.write("							<span class=\"flaticon-tour\"></span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"process-cap\">\r\n");
      out.write("							<h5>3. Get your job</h5>\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- Testimonial End -->\r\n");
      out.write("	<!-- Support Company Start-->\r\n");
      out.write("	<!-- Support Company Start-->\r\n");
      out.write("<div class=\"support-company-area support-padding fix\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row align-items-center\">\r\n");
      out.write("            <div class=\"col-xl-6 col-lg-6\">\r\n");
      out.write("                <div class=\"right-caption\">\r\n");
      out.write("                    <!-- Section Tittle -->\r\n");
      out.write("                    <div class=\"section-tittle section-tittle2\">\r\n");
      out.write("                        <span>What we are doing</span>\r\n");
      out.write("                        <h2>Empowering 1k Talented Individuals</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"support-caption\">\r\n");
      out.write("                        <p class=\"pera-top\">Currently, many people are seeking jobs, and at the same time, numerous recruiters are eager to connect with potential candidates. Recognizing this need, we have developed a website that helps candidates and recruiters find each other. The website provides job opportunities for candidates, and they can also upload their CV for recruiters to see. If they pass the online application process on the website, candidates...</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Move the image here -->\r\n");
      out.write("            <div class=\"col-xl-6 col-lg-6 text-center\">\r\n");
      out.write("                <div class=\"support-location-img\">\r\n");
      out.write("                    <img src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" alt=\"\" />\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Support Company End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /views/web/home.jsp(15,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/assets/img/service/about.jpg");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /views/web/home.jsp(111,19) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/assets/img/gallery/how-applybg.png");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent(null);
      // /views/web/home.jsp(181,30) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/assets/img/service/about.jpg");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
    }
    return false;
  }
}
