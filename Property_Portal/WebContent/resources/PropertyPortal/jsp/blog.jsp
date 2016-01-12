<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-US">

<!-- Mirrored from mariusn.com/themes/reales-wp/blog/ by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 25 Sep 2015 12:39:14 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!-- /Added by HTTrack -->
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Blog</title>
<link rel="pingback"
	href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/xmlrpc.php">
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<meta name="google-signin-clientid"
	content="661558541389-4rkd1mee6bu16ubfdkp4p3m25584ksor.apps.googleusercontent.com" />
<meta name="google-signin-scope"
	content="https://www.googleapis.com/auth/plus.login" />
<meta name="google-signin-requestvisibleactions"
	content="http://schema.org/AddAction" />
<meta name="google-signin-cookiepolicy" content="single_host_origin" />

<meta name='robots' content='noindex,follow' />
<link rel="alternate" type="application/rss+xml"
	title="Reales WP &raquo; Feed"
	href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/feed/index.html" />
<link rel="alternate" type="application/rss+xml"
	title="Reales WP &raquo; Comments Feed"
	href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/comments/feed/index.html" />
<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"http:\/\/s.w.org\/images\/core\/emoji\/72x72\/","ext":".png","source":{"concatemoji":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.2.5"}};
			!function(a,b,c){function d(a){var c=b.createElement("canvas"),d=c.getContext&&c.getContext("2d");return d&&d.fillText?(d.textBaseline="top",d.font="600 32px Arial","flag"===a?(d.fillText(String.fromCharCode(55356,56812,55356,56807),0,0),c.toDataURL().length>3e3):(d.fillText(String.fromCharCode(55357,56835),0,0),0!==d.getImageData(16,16,1,1).data[0])):!1}function e(a){var c=b.createElement("script");c.src=a,c.type="text/javascript",b.getElementsByTagName("head")[0].appendChild(c)}var f,g;c.supports={simple:d("simple"),flag:d("flag")},c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.simple&&c.supports.flag||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener("DOMContentLoaded",g,!1),a.addEventListener("load",g,!1)):(a.attachEvent("onload",g),b.attachEvent("onreadystatechange",function(){"complete"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
<style type="text/css">
img.wp-smiley, img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}
</style>
<link rel='stylesheet' id='dsidx-css'
	href='http://cdn3.diverse-cdn.com/api/combo-css/config=dsidxpress.css/e4901c'
	type='text/css' media='all' />
<link rel='stylesheet' id='reales_plugin_style-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/short-tax-post/css/style5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='datepicker_style-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/short-tax-post/css/datepicker5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='dsidxpress-unconditional-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/dsidxpress/css/clientd19b.css?ver=4.2.5'
	type='text/css' media='all' />
<link rel='stylesheet' id='dsidxwidgets-unconditional-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/dsidxpress/dsidxwidgets/css/clientd19b.css?ver=4.2.5'
	type='text/css' media='all' />
<link rel='stylesheet' id='font_awesome-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/font-awesome5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='simple_line_icons-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/simple-line-icons5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='jquery_ui-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/jquery-ui5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='file_input-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/fileinput.min5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='bootstrap_style-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/bootstrap5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='datepicker-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/datepicker5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='fancybox-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/jquery.fancybox5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='fancybox_buttons-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/jquery.fancybox-buttons5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='reales_style-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/style5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='idx_style-css'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/css/idx5152.css?ver=1.0'
	type='text/css' media='all' />
<script type='text/javascript'
	src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/jquery4a80.js?ver=1.11.2'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/jquery-migrate.min1576.js?ver=1.2.1'></script>
<script type='text/javascript'
	src='http://cdn1.diverse-cdn.com/api/combo-js/config=dsidxpress.js/38878d?ver=2.1.23'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/plupload/plupload.full.mine1fc.js?ver=2.1.1'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var pluploadL10n = {"queue_limit_exceeded":"You have attempted to queue too many files.","file_exceeds_size_limit":"%s exceeds the maximum upload size for this site.","zero_byte_file":"This file is empty. Please try another.","invalid_filetype":"This file type is not allowed. Please try another.","not_an_image":"This file is not an image. Please try another.","image_memory_exceeded":"Memory exceeded. Please try another smaller file.","image_dimensions_exceeded":"This is larger than the maximum size. Please try another.","default_error":"An error occurred in the upload. Please try again later.","missing_upload_url":"There was a configuration error. Please contact the server administrator.","upload_limit_exceeded":"You may only upload 1 file.","http_error":"HTTP error.","upload_failed":"Upload failed.","big_upload_failed":"Please try uploading this file with the %1$sbrowser uploader%2$s.","big_upload_queued":"%s exceeds the maximum upload size for the multi-file uploader when used in your browser.","io_error":"IO error.","security_error":"Security error.","file_cancelled":"File canceled.","upload_stopped":"Upload stopped.","dismiss":"Dismiss","crunching":"Crunching\u2026","deleted":"moved to the trash.","error_uploading":"\u201c%s\u201d has failed to upload."};
/* ]]> */
</script>
<script type='text/javascript'
	src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/plupload/handlers.mind19b.js?ver=4.2.5'></script>
<link rel="EditURI" type="application/rsd+xml" title="RSD"
	href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/xmlrpc0db0.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml"
	href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/wlwmanifest.xml" />
<meta name="generator" content="WordPress 4.2.5" />
<style type='text/css'>
.slideshowShadow {
	background-color: rgba(0, 0, 0, 0.40) !important;
}

.btn-green {
	background-color: #0eaaa6 !important;
}

.btn-o.btn-green {
	background-color: transparent !important;
	color: #0eaaa6 !important;
	border-color: #0eaaa6 !important;
}

.no-touch .btn-o.btn-green:hover, .btn-o.btn-green:focus, .btn-o.btn-green:active,
	.btn-o.btn-green.active, .open>.dropdown-toggle.btn-o.btn-green {
	background-color: #0eaaa6 !important;
	color: #fff !important;
}

.text-green {
	color: #0eaaa6 !important;
}

.logo {
	background-color: #0eaaa6 !important;
}

.no-touch .userMenu ul>li>a:hover>span, .no-touch .userMenu ul>li>a:focus>span
	{
	color: #0eaaa6 !important;
}

.stLabel {
	background-color: #0eaaa6 !important;
}

.stArrow {
	border-top-color: #0eaaa6 !important;
}

.ui-slider .ui-slider-range {
	background-color: #0eaaa6 !important;
}

.no-touch a.card:hover h2, .no-touch div.card:hover h2 {
	color: #0eaaa6 !important;
}

.no-touch .similar a.similarProp:hover .info .name {
	color: #0eaaa6 !important;
}

.amItem.active span {
	color: #0eaaa6 !important;
}

.no-touch .propsWidget ul.propList li a:hover .info .name {
	color: #0eaaa6 !important;
}

.no-touch .agentsWidget ul.agentsList li a:hover .info .name {
	color: #0eaaa6 !important;
}

.pagination>.active>a, .pagination>.active>span, .no-touch .pagination>.active>a:hover,
	.no-touch .pagination>.active>span:hover, .pagination>.active>a:focus,
	.pagination>.active>span:focus {
	background-color: #0eaaa6 !important;
	border-color: #0eaaa6 !important;
}

.page-links>span {
	background-color: #0eaaa6 !important;
}

.progress-bar-green {
	background-color: #0eaaa6 !important;
}

.spotlight {
	background-color: #0eaaa6 !important;
}

.s-icon {
	color: #0eaaa6 !important;
}

.label-green {
	background-color: #0eaaa6 !important;
}

h2.s-main {
	color: #0eaaa6 !important;
}

.no-touch .s-menu-item:hover .s-icon {
	color: #fff !important;
}

.no-touch .s-menu-item:hover .s-main {
	color: #fff !important;
}

.no-touch .s-menu-item:hover {
	background-color: #0eaaa6 !important;
}

.no-touch .article h3 a:hover {
	color: #0eaaa6 !important;
}

.blog-pagination a {
	border: 1px solid #0eaaa6 !important;
	color: #0eaaa6 !important;
}

.no-touch .blog-pagination a:hover {
	color: #fff !important;;
	background-color: #0eaaa6 !important;
}

blockquote {
	border-left: 2px solid #0eaaa6 !important;
}

.no-touch .f-p-article:hover .fpna-header, .no-touch .f-n-article:hover .fpna-header
	{
	color: #0eaaa6 !important;
}

.comment-navigation a {
	border: 1px solid #0eaaa6 !important;
	color: #0eaaa6 !important;
}

.no-touch .comment-navigation a:hover {
	background-color: #0eaaa6 !important;
	color: #fff !important;
}

.comment-form input[type="submit"] {
	border: 1px solid #0eaaa6 !important;
	background-color: #0eaaa6 !important;
}

#wp-calendar tbody tr td a {
	color: #0eaaa6 !important;
}

.no-touch .content-sidebar .agentsWidget ul.agentsList li a:hover .info .name
	{
	color: #0eaaa6 !important;
}

.no-touch .content-sidebar .propsWidget ul.propList li a:hover .info .name
	{
	color: #0eaaa6 !important;
}

.datepicker td.day:hover {
	color: #0eaaa6 !important;
}

.datepicker td.active, .datepicker td.active:hover {
	color: #ffffff !important;
	background-color: #0eaaa6 !important;
}

.datepicker td span.active {
	color: #ffffff !important;
	background-color: #0eaaa6 !important;
}

.datepicker thead tr:first-child th:hover {
	color: #0eaaa6 !important;
}

@media screen and (max-width: 767px) {
	#header {
		background-color: #0eaaa6 !important;
	}
	.logo {
		background-color: transparent !important;
	}
}

.no-touch #dsidx-listings .dsidx-primary-data .dsidx-address a:hover {
	color: #0eaaa6 !important;
}

.no-touch ul.dsidx-list.dsidx-panel li a:hover {
	color: #0eaaa6 !important;
}

.no-touch div.dsidx-results-widget .dsidx-slideshow-control:hover {
	background-color: #0eaaa6 !important;
	color: #fff !important;
}

.no-touch div.dsidx-results-widget h4 a:hover {
	color: #0eaaa6 !important;
}

.no-touch .dsidx-widget-single-listing h3.widget-title a:hover {
	color: #0eaaa6 !important;
}

.no-touch .dsidx-prop-summary .dsidx-prop-title a:hover {
	color: #0eaaa6 !important;
}

.no-touch h4.dsidx-address a:hover {
	color: #0eaaa6 !important;
}

.no-touch .btn-green:hover, .btn-green:focus, .btn-green:active,
	.btn-green.active, .open>.dropdown-toggle.btn-green {
	background-color: #068b85 !important;
	color: #fff !important;
}

.no-touch a.text-green:hover {
	color: #068b85 !important;
}

.no-touch a.bg-green:hover {
	background-color: #068b85 !important;
}

.comment-form input[type="submit"]:hover {
	background-color: #068b85 !important;
	border: 1px solid #068b85 !important;
}

.footer-nav .searchform input[type="submit"] {
	background-color: #068b85 !important;
}

.content-sidebar .searchform input[type="submit"] {
	background-color: #068b85 !important;
}

.datepicker td.active:hover, .datepicker td.active:hover:hover,
	.datepicker td.active:focus, .datepicker td.active:hover:focus,
	.datepicker td.active:active, .datepicker td.active:hover:active,
	.datepicker td.active.active, .datepicker td.active:hover.active,
	.datepicker td.active.disabled, .datepicker td.active:hover.disabled,
	.datepicker td.active[disabled], .datepicker td.active:hover[disabled]
	{
	color: #ffffff !important;
	background-color: #068b85 !important;
}

.datepicker td.active:active, .datepicker td.active:hover:active,
	.datepicker td.active.active, .datepicker td.active:hover.active {
	background-color: #068b85\9 !important;
}

.datepicker td span.active:hover, .datepicker td span.active:focus,
	.datepicker td span.active:active, .datepicker td span.active.active,
	.datepicker td span.active.disabled, .datepicker td span.active[disabled]
	{
	color: #ffffff !important;
	background-color: #068b85 !important;
}

.datepicker td span.active:active, .datepicker td span.active.active {
	background-color: #068b85\9 !important;
}

#leftSide {
	background-color: #213837 !important;
}

.leftNav>div>ul>li>a {
	color: #adc8c7 !important;
}

.expanded .leftNav>ul>li.onTap>a {
	color: #adc8c7 !important;
}

@media screen and (max-width: 767px) {
	.searchIcon {
		color: #adc8c7 !important;
	}
	.search input::-webkit-input-placeholder {
		color: #adc8c7 !important;
	}
	.search input:-moz-placeholder {
		color: #adc8c7 !important;
	}
	.search input::-moz-placeholder {
		color: #adc8c7 !important;
	}
	.search input:-ms-input-placeholder {
		color: #adc8c7 !important;
	}
}

.leftNav>div>ul>li>ul>li>a {
	color: #96adac !important;
}

.no-touch .leftNav>div>ul>li:hover>ul>li>a, .leftNav>div>ul>li.onTap>ul>li>a
	{
	color: #96adac !important;
	/* background-color: #132120; */
}

.no-touch .leftNav>div>ul>li:hover>a, .leftNav>div>ul>li.onTap>a {
	background-color: #067670 !important;
	color: #fff !important;
}

.expanded .leftNav>ul>li.active>a {
	background-color: #067670 !important;
	color: #fff !important;
}

.leftNav>div>ul>li>ul {
	background-color: #132120 !important;
}

.no-touch .leftNav>div>ul>li>ul {
	background-color: #132120 !important;
}

.no-touch .leftNav>div>ul>li:hover>ul>li>a, .leftNav>div>ul>li.onTap>ul>li>a
	{
	/* color: #96adac; */
	background-color: #132120 !important;
}

@media screen and (max-width: 767px) {
	.leftNav .search {
		background-color: #132120 !important;
	}
	.search input {
		background-color: #132120 !important;
		color: #fff !important;
	}
}

.no-touch .leftNav>div>ul>li>ul>li>a:hover {
	color: #fff !important;
	background-color: #05635e !important;
}

@media screen and (max-width: 767px) {
	.no-touch a.mapHandler:hover {
		color: #c6e4e3 !important;
	}
	.no-touch #header a.userHandler:hover {
		color: #c6e4e3 !important;
	}
	.no-touch #header a.navHandler:hover {
		color: #c6e4e3 !important;
	}
}

.home-footer {
	background-color: #333333 !important;
}

.footer-header {
	color: #c6e4e3 !important;
}

.propType {
	background-color: #eab134 !important;
}

.figType {
	background-color: #eab134 !important;
}

.similar a.similarProp .info .price .badge {
	background-color: #eab134 !important;
}

.propWidget-1 .fig .figType {
	background-color: #eab134 !important;
}

.propWidget-2 .fig .figType {
	background-color: #eab134 !important;
}

.propWidget-3 .priceCap .type {
	background-color: #eab134 !important;
}

.propsWidget ul.propList li a .info .price .badge {
	background-color: #eab134 !important;
}

.label-yellow {
	background-color: #eab134 !important;
}

.favLink .addFav, .favLink .addedFav, .favLink .noSigned {
	color: #ea3d36 !important;
}

.no-touch .favLink a.addFav:hover span, .no-touch .favLink a.noSigned:hover span
	{
	color: #ea3d36 !important;
}

.figStatus {
	background-color: #ea3d36 !important;
}
</style>
<style type="text/css" media="screen">
html {
	margin-top: 0px !important;
}

* html body {
	margin-top: 0px !important;
}
</style>
<script type="text/javascript">
				if (typeof localdsidx == "undefined" || !localdsidx) { var localdsidx = {}; };
				localdsidx.pluginUrl = "${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/dsidxpress/index.html";
				localdsidx.homeUrl = "http://mariusn.com/themes/reales-wp";
				</script>
<script type="text/javascript">
				if (typeof localdsidx == "undefined" || !localdsidx) { var localdsidx = {}; };
				localdsidx.pluginUrl = "${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/dsidxpress/index.html";
				localdsidx.homeUrl = "http://mariusn.com/themes/reales-wp";
				</script>
</head>


<body class="blog no-transition">

	<div id="carouselBlog" class="carousel slide featured"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselBlog" data-slide-to="0" class="active"></li>
			<li data-target="#carouselBlog" data-slide-to="1"></li>
			<li data-target="#carouselBlog" data-slide-to="2"></li>
			<li data-target="#carouselBlog" data-slide-to="3"></li>
		</ol>
		<c:forEach items="${blogList}" var="blog">
			<div class="carousel-inner">
				<div class="item"
					style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/images/blogImage.jpg)">
					<div class="container">
						<div class="carousel-caption">
							<div class="carousel-title">Featured on Blog</div>
							<div class="caption-title">${blog.blogTitle}</div>
							<div class="caption-subtitle">${blog.authorName}[&hellip;]</div>
							<%-- <div class="caption-subtitle">${blog.blog} [&hellip;]</div> --%>
							<a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/how-does-a-designer-home-look-like/index.html"
								class="btn btn-lg btn-o btn-white">Read More</a>
						</div>
						<div class="avatar-caption">
							<img
								src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/11/avatar.png"
								alt="admin">
							<div class="ac-user">
								<div class="ac-name">${blog.builderId}</div>
								<div class="ac-title">${blog.blogDate}</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<%-- <div class="item"
				style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-3.jpg)">
				<div class="container">
					<div class="carousel-caption">
						<div class="carousel-title">Featured on Blog</div>
						<div class="caption-title">Luminous 3 Bedroom Apartment
							Flaunting Modern Style</div>
						<div class="caption-subtitle">There are many variations of
							passages of Lorem Ipsum available It is a long established fact
							that a reader will be distracted by the readable content of a
							page when [&hellip;]</div>
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/luminous-3-bedroom-apartment-flaunting-modern-style/index.html"
							class="btn btn-lg btn-o btn-white">Read More</a>
					</div>
					<div class="avatar-caption">
						<img
							src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/11/avatar.png"
							alt="admin">
						<div class="ac-user">
							<div class="ac-name">admin</div>
							<div class="ac-title">Dec 28, 2014</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div> --%>
				<%-- <div class="item"
				style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-5.jpg)">
				<div class="container">
					<div class="carousel-caption">
						<div class="carousel-title">Featured on Blog</div>
						<div class="caption-title">Provocative Home Design
							Re-Shaping The Landscape</div>
						<div class="caption-subtitle">There are many variations of
							passages of Lorem Ipsum available It is a long established fact
							that a reader will be distracted by the readable content of a
							page when [&hellip;]</div>
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/provocative-home-design-re-shaping-the-landscape/index.html"
							class="btn btn-lg btn-o btn-white">Read More</a>
					</div>
					<div class="avatar-caption">
						<img
							src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/11/avatar.png"
							alt="admin">
						<div class="ac-user">
							<div class="ac-name">admin</div>
							<div class="ac-title">Dec 28, 2014</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div> --%>
				<%-- <div class="item"
				style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-1.jpg)">
				<div class="container">
					<div class="carousel-caption">
						<div class="carousel-title">Featured on Blog</div>
						<div class="caption-title">Subtly Twisting Geometry Inserted
							in Raw Nature</div>
						<div class="caption-subtitle">There are many variations of
							passages of Lorem Ipsum available It is a long established fact
							that a reader will be distracted by the readable content of a
							page when [&hellip;]</div>
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/subtly-twisting-geometry-inserted-in-raw-nature/index.html"
							class="btn btn-lg btn-o btn-white">Read More</a>
					</div>
					<div class="avatar-caption">
						<img
							src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/11/avatar.png"
							alt="admin">
						<div class="ac-user">
							<div class="ac-name">admin</div>
							<div class="ac-title">Dec 27, 2014</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div> --%>
			</div>
		</c:forEach>
		<a class="left carousel-control" href="#carouselBlog" role="button"
			data-slide="prev"><span class="fa fa-chevron-left"></span></a><a
			class="right carousel-control" href="#carouselBlog" role="button"
			data-slide="next"><span class="fa fa-chevron-right"></span></a>
	</div>
	<div class="home-header">
		<div class="home-logo osLight">
			<a href="index.html"> <img
					src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/images/logo1.png"
					style="height: 100px">
					</a>
		</div>

		<!-- <div class="topUserWraper">
			<a href="#" class="userNavHandler"><span class="icon-user"></span></a>
			<div class="user-nav">
				<ul>
					<li><a href="#" data-toggle="modal" data-target="#signup">Sign
							Up</a></li>
					<li><a href="#" data-toggle="modal" data-target="#signin">Sign
							In</a></li>
				</ul>
			</div>
		</div>
 -->
		<%-- <div class="modal fade" id="signin" role="dialog"
			aria-labelledby="signinLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="signinLabel">Sign In</h4>
					</div>
					<div class="modal-body">
						<form role="form" id="userLoginForm" method="post">
							<div class="signinMessage" id="signinMessage"></div>
							<div id="fb-root"></div>
							<script>
                        window.fbAsyncInit = function() {
                            FB.init({
                                appId      : 743545722392313,
                                status     : true,
                                cookie     : true,
                                xfbml      : true,
                                version    : 'v2.1'
                            });
                        };
                        (function(d, s, id) {
                            var js, fjs = d.getElementsByTagName(s)[0];
                            if (d.getElementById(id)) return;
                            js = d.createElement(s); js.id = id;
                            js.src = "${pageContext.request.contextPath}/resources/PropertyPortal/assets/${pageContext.request.contextPath}/resources/PropertyPortal/assets/${pageContext.request.contextPath}/resources/PropertyPortal/assets/${pageContext.request.contextPath}/resources/PropertyPortal/assets/connect.facebook.net/en_US/sdk.js";
                            fjs.parentNode.insertBefore(js, fjs);
                        }(document, 'script', 'facebook-jssdk'));
                    </script>
							<div class="form-group">
								<div class="btn-group-justified">
									<a href="#" class="btn btn-lg btn-facebook" id="fbLoginBtn"><span
										class="fa fa-facebook pull-left"></span><span
										class="signinFBText">Sign In with Facebook</span></a>
								</div>
							</div>
							<div class="form-group">
								<div class="btn-group-justified">
									<a href="#" class="btn btn-lg btn-google" id="googleSigninBtn"><span
										class="fa fa-google-plus pull-left"></span><span
										class="signinGText">Sign In with Google</span></a>
								</div>
							</div>
							<div class="signOr">OR</div>
							<div class="form-group">
								<input type="text" name="usernameSignin" id="usernameSignin"
									placeholder="Username" class="form-control">
							</div>
							<div class="form-group">
								<input type="password" name="passwordSignin" id="passwordSignin"
									placeholder="Password" class="form-control">
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-xs-6">
										<div class="checkbox custom-checkbox">
											<label><input type="checkbox" id="rememberSignin"
												name="rememberme" value="forever"><span
												class="fa fa-check"></span> Remember me</label>
										</div>
									</div>
									<div class="col-xs-6 align-right">
										<p class="help-block">
											<a href="#" class="text-green forgotPass">Forgot
												password?</a>
										</p>
									</div>
								</div>
							</div>
							<input type="hidden" id="securitySignin" name="securitySignin"
								value="294027b2cd" /><input type="hidden"
								name="_wp_http_referer" value="/themes/reales-wp/blog/" />
							<div class="form-group">
								<div class="btn-group-justified">
									<a href="#" class="btn btn-lg btn-green" id="submitSignin">Sign
										In</a>
								</div>
							</div>
							<p class="help-block">
								Don't have an account? <a href="#" class="modal-su text-green">Sign
									Up</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
 --%>
		<%-- <div class="modal fade" id="signup" role="dialog"
			aria-labelledby="signupLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="signupLabel">Sign Up</h4>
					</div>
					<div class="modal-body">
						<form role="form" id="userSignupForm" method="post">
							<div class="signinMessage" id="signupMessage"></div>
							<div class="form-group">
								<div class="checkbox custom-checkbox">
									<label><input type="checkbox" id="register_as_agent"
										name="register_as_agent" value="1"><span
										class="fa fa-check"></span> Register me as agent</label>
								</div>
							</div>
							<div class="form-group">
								<input type="text" name="usernameSignup" id="usernameSignup"
									placeholder="Username" class="form-control">
							</div>
							<div class="form-group">
								<input type="text" name="firstnameSignup" id="firstnameSignup"
									placeholder="First Name" class="form-control">
							</div>
							<div class="form-group">
								<input type="text" name="lastnameSignup" id="lastnameSignup"
									placeholder="Last Name" class="form-control">
							</div>
							<div class="form-group">
								<input type="text" name="emailSignup" id="emailSignup"
									placeholder="Email Address" class="form-control">
							</div>
							<div class="form-group">
								<input type="password" name="pass1Signup" id="pass1Signup"
									placeholder="Password" class="form-control">
							</div>
							<div class="form-group">
								<input type="password" name="pass2Signup" id="pass2Signup"
									placeholder="Confirm Password" class="form-control">
							</div>
							<div class="form-group">
								<p class="help-block">
									<a href="#" class="text-green forgotPass">Forgot password?</a>
								</p>
							</div>
							<input type="hidden" id="securitySignup" name="securitySignup"
								value="8058825d1b" /><input type="hidden"
								name="_wp_http_referer" value="/themes/reales-wp/blog/" />
							<div class="form-group">
								<div class="btn-group-justified">
									<a class="btn btn-lg btn-green" id="submitSignup">Sign Up</a>
								</div>
							</div>
							<p class="help-block">
								Already a member? <a href="#" class="modal-si text-green">Sign
									In</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
 --%>
		<%-- <div class="modal fade" id="forgot" role="dialog"
			aria-labelledby="forgotLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="forgotLabel">Forgot Password</h4>
					</div>
					<div class="modal-body">
						<form role="form" id="userForgotPassForm" method="post">
							<div class="forgotMessage" id="forgotMessage"></div>
							<div class="form-group forgotField">
								<input type="text" name="emailForgot" id="emailForgot"
									placeholder="Username or Email address" class="form-control">
							</div>
							<input type="hidden" id="securityForgot" name="securityForgot"
								value="692eb5192a" /><input type="hidden"
								name="_wp_http_referer" value="/themes/reales-wp/blog/" />
							<div class="form-group forgotField">
								<div class="btn-group-justified">
									<a href="#" class="btn btn-lg btn-green" id="submitForgot">Get
										New Password</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
 --%>
		<%-- <div class="modal fade" id="resetpass" role="dialog"
			aria-labelledby="resetpassLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="resetpassLabel">Reset Password</h4>
					</div>
					<div class="modal-body">
						<form role="form" id="userResetPassForm" method="post">
							<div class="resetPassMessage" id="resetPassMessage"></div>
							<div class="form-group">
								<input type="password" name="resetPass_1" id="resetPass_1"
									placeholder="New Password" class="form-control">
							</div>
							<div class="form-group">
								<input type="password" name="resetPass_2" id="resetPass_2"
									placeholder="Confirm Password" class="form-control">
							</div>
							<p class="help-block">Hint: The password should be at least
								seven characters long. To make it stronger, use upper and lower
								case letters, numbers, and symbols like ! " ? $ % ^ & ).</p>
							<input type="hidden" id="securityResetpass"
								name="securityResetpass" value="e64a135f6f" /><input
								type="hidden" name="_wp_http_referer"
								value="/themes/reales-wp/blog/" />
							<div class="form-group">
								<div class="btn-group-justified">
									<a href="#" class="btn btn-lg btn-green" id="submitResetPass">Reset
										Password</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div> --%>
		<a href="javascript:void(0);" class="top-navHandler visible-xs"><span
			class="fa fa-bars"></span></a>
		<div class="top-nav">
			<div class="menu-top-menu-container">
				<ul id="menu-top-menu" class="menu">
					<li id="menu-item-225"
						class="xxx menu-item menu-item-type-post_type menu-item-object-page menu-item-225"><a
						href="./property-home.htm">Home</a></li>
					<%-- <li id="menu-item-556"
						class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-556"><a
						href="#">Properties</a>
						<ul class="sub-menu">
							<li id="menu-item-555"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-555"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/index37da.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Properties
									List</a></li>
							<li id="menu-item-557"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-557"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/elegant-apartment/index.html">Single
									Property</a></li>
							<li id="menu-item-558"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-558"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/index37da.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Search
									by City</a></li>
							<li id="menu-item-559"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-559"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/index259b.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=29&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Search
									by Category</a></li>
							<li id="menu-item-560"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-560"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/indexaa47.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=10&amp;search_min_price=&amp;search_max_price=">Search
									by Type</a></li>
							<li id="menu-item-561"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-561"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/indexea21.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=700000">Search
									by Price</a></li>
						</ul></li> --%>
					<%-- <li id="menu-item-2459"
						class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-2459"><a
						href="#">IDX</a>
						<ul class="sub-menu">
							<li id="menu-item-2460"
								class="menu-item menu-item-type-post_type menu-item-object-ds-idx-listings-page menu-item-2460"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/idx/listings/idx-test/index.html">dsIDXpress
									Listings</a></li>
							<li id="menu-item-2461"
								class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2461"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/dsidxpress-single-listing-shortcode/index.html">dsIDXpress
									Single Listing Shortcode</a></li>
							<li id="menu-item-2462"
								class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2462"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/dsidxpress-listings-shortcode/index.html">dsIDXpress
									Listings Shortcode</a></li>
						</ul></li> --%>
					<%-- <li id="menu-item-562"
						class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-562"><a
						href="#">Agents</a>
						<ul class="sub-menu">
							<li id="menu-item-563"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-563"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/agents/jane-smith/index.html">Agent
									Page</a></li>
						</ul></li> --%>
					<li id="menu-item-269"
						class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-265 current_page_item current_page_parent menu-item-269"><a
						href="./blogs.htm">Blog</a></li>
					<%-- <li id="menu-item-564"
						class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-564"><a
						href="#">Features</a>
						<ul class="sub-menu">
							<li id="menu-item-578"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-578"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/front-end-property-submission/index.html">Front-end
									Property Submission</a></li>
							<li id="menu-item-588"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-588"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/reales-wp-custom-widgets/index.html">Custom
									Widgets</a></li>
							<li id="menu-item-595"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-595"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/reales-wp-shortcodes/index.html">Reales
									WP Shortcodes</a></li>
						</ul></li> --%>
					<li id="menu-item-519"
						class="menu-item menu-item-type-post_type menu-item-object-page menu-item-519"><a
						href="./contactUs.htm">Contact
							Us</a></li>
				</ul>
			</div>
		</div>
	</div>
	


	<div id="" class="page-wrapper">
		<div class="page-content">

			<div class="row pull-right">
				<li id="recent_properties_widget-3"
					class="widget-container recent_properties_sidebar"><h3
						class="osLight sidebar-header">Recently Listed Properties</h3>
						<c:if test="${empty projectList}">
					<div>
						<h4 class="pageHeader">
							<span style="color: red;">${NOPROJECTSFOUND}</span>
						</h4>
					</div>
				</c:if>
				<c:if test="${not empty projectList}">
						 <c:forEach	items="${projectList}" var="projectDto">
						<div class="propsWidget">
							<ul class="propList">
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/modern-residence/index.html"><div
											class="image">
											<img
												src="${projectDto.imageUrl}"
												alt="Recently Listed Properties" />
										</div>
										<div class="info text-nowrap">
											<div class="name">${projectDto.popertyName}</div>
											<div class="address">${projectDto.siteAddress}</div>
											<div class="price">${projectDto.cost}<span
													class="badge">For Sale</span>
											</div>
										</div>
										<div class="clearfix"></div></a></li>
							</ul>
						</div>
					</c:forEach></c:if></li>
				<li id="featured_agents_widget-4"
					class="widget-container featured_agents_sidebar"><h3
						class="osLight sidebar-header">Our Agents</h3> 
						<c:if test="${empty agentList}">
					<div>
						<h4 class="pageHeader">
							<span style="color: red;">${NOAGENTSFOUND}</span>
						</h4>
					</div>
				</c:if>
				<c:if test="${not empty agentList}">
						<c:forEach items="${agentList}" var="builderDto">
						<div class="agentsWidget">
							<ul class="agentsList">
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/agents/antony-iglesias/index.html"><div
											class="image">
											<img
												src="${builderDto.imageUrl}"
												alt="Our Agents" />
										</div>
										<div class="info text-nowrap">
											<div class="name">${builderDto.builderName}</div>
											<div class="title">Houses and lands</div>
										</div>
										<div class="clearfix"></div></a></li>

							</ul>
						</div>
					</c:forEach></c:if></li>


			</div>
			<div class="row">
				<h2 class="pageHeader">Latest Posts</h2>
				<c:if test="${empty blogList}">
					<div>
						<h2 class="pageHeader">
							<span style="color: red;">${NOBLOGSFOUND}</span>
						</h2>
					</div>
				</c:if>
				<c:if test="${not empty blogList}">
					<c:forEach items="${blogList}" var="blog">
						<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">

							<div class="row">

								<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
									<div
										class="post-290 post type-post status-publish format-standard has-post-thumbnail hentry category-architecture tag-modern">
										<div class="article bg-w">
											<a
												href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/modern-two-level-pool-house-in-los-angeles/index.html"
												class="image">
												<div class="img"
													style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/images/blogImage.jpg)"></div>
											</a>
											<div class="article-category">
												<a class="text-green"
													href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/architecture/index.html"
													title="View all posts in Architecture">Architecture</a>
											</div>
											<h3>
												<a
													href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/modern-two-level-pool-house-in-los-angeles/index.html">${blog.blogTitle}</a>
												<span class="label label-green sticky-label">Featured</span>
											</h3>
											<p>${blog.blog}[&hellip;]</p>
											<div class="footer">${blog.builderId}</div>
											<div class="footer">${blog.blogDate}</div>
										</div>
									</div>
								</div>


								<%-- 							 <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<div
								class="post-286 post type-post status-publish format-standard has-post-thumbnail hentry category-architecture tag-modern">
								<div class="article bg-w">
									<a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/private-contemporary-home-balancing-openness/index.html"
										class="image">
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-2.jpg);"></div>
									</a>
									<div class="article-category">
										<a class="text-green"
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/architecture/index.html"
											title="View all posts in Architecture">Architecture</a>
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/private-contemporary-home-balancing-openness/index.html">${blog.blogTitle}</a> <span
											class="label label-green sticky-label">Featured</span>
									</h3>
								<div class="footer">${blog.builderId}</div>
										<div class="footer">${blog.blogDate}</div>
								</div>
							</div>
						</div> --%>

								<%-- <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<div
								class="post-282 post type-post status-publish format-standard has-post-thumbnail hentry category-architecture tag-modern">
								<div class="article bg-w">
									<a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/stylish-modern-ranch-exuding-a-welcoming-feel/index.html"
										class="image">
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-6.jpg);"></div>
									</a>
									<div class="article-category">
										<a class="text-green"
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/architecture/index.html"
											title="View all posts in Architecture">Architecture</a>
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/stylish-modern-ranch-exuding-a-welcoming-feel/index.html">Stylish
											Modern Ranch Exuding a Welcoming Feel</a> <span
											class="label label-green sticky-label">Featured</span>
									</h3>
									<div class="footer">admin, Dec 28, 2014</div>
								</div>
							</div>
						</div>
 --%>

								<%-- <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
							<div
								class="post-278 post type-post status-publish format-standard has-post-thumbnail hentry category-living-room tag-modern">
								<div class="article bg-w">
									<a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/how-does-a-designer-home-look-like/index.html"
										class="image">
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/blog-1.jpg);"></div>
									</a>
									<div class="article-category">
										<a class="text-green"
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/living-room/index.html"
											title="View all posts in Living Room">Living Room</a>
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/how-does-a-designer-home-look-like/index.html">How
											Does A Designer Home Look Like</a> <span
											class="label label-green sticky-label">Featured</span>
									</h3>
									<p>There are many variations of passages of Lorem Ipsum
										available It is a long established fact that a reader will be
										distracted by the readable content of a page when [&hellip;]</p>
									<div class="footer">admin, Dec 28, 2014</div>
								</div>
							</div>
						</div>
 --%>

								<%-- <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<div
								class="post-274 post type-post status-publish format-standard has-post-thumbnail hentry category-apartments tag-modern">
								<div class="article bg-w">
									<a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/luminous-3-bedroom-apartment-flaunting-modern-style/index.html"
										class="image">
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-3.jpg);"></div>
									</a>
									<div class="article-category">
										<a class="text-green"
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/apartments/index.html"
											title="View all posts in Apartments">Apartments</a>
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/luminous-3-bedroom-apartment-flaunting-modern-style/index.html">Luminous
											3 Bedroom Apartment Flaunting Modern Style</a> <span
											class="label label-green sticky-label">Featured</span>
									</h3>
									<div class="footer">admin, Dec 28, 2014</div>
								</div>
							</div>
						</div>

 --%>
								<%-- 	<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<div
								class="post-270 post type-post status-publish format-standard has-post-thumbnail hentry category-architecture tag-cool tag-modern">
								<div class="article bg-w">
									<a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/provocative-home-design-re-shaping-the-landscape/index.html"
										class="image">
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-5.jpg);"></div>
									</a>
									<div class="article-category">
										<a class="text-green"
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/architecture/index.html"
											title="View all posts in Architecture">Architecture</a>
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/provocative-home-design-re-shaping-the-landscape/index.html">Provocative
											Home Design Re-Shaping The Landscape</a> <span
											class="label label-green sticky-label">Featured</span>
									</h3>
									<div class="footer">admin, Dec 28, 2014</div>
								</div>
							</div>
						</div>
 --%>

								<%-- <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<div
								class="post-261 post type-post status-publish format-standard has-post-thumbnail hentry category-architecture">
								<div class="article bg-w">
									<a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/subtly-twisting-geometry-inserted-in-raw-nature/index.html"
										class="image">
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-1.jpg);"></div>
									</a>
									<div class="article-category">
										<a class="text-green"
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/category/architecture/index.html"
											title="View all posts in Architecture">Architecture</a>
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/subtly-twisting-geometry-inserted-in-raw-nature/index.html">Subtly
											Twisting Geometry Inserted in Raw Nature</a> <span
											class="label label-green sticky-label">Featured</span>
									</h3>
									<div class="footer">admin, Dec 27, 2014</div>
								</div>
							</div>
						</div>
 --%>
							</div>
							<div class="blog-pagination">
								<div class="pull-left"></div>
								<div class="pull-right"></div>
								<div class="clearfix"></div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
					<div class="content-sidebar">
						<ul class="sidebar-list">
							<%-- <li id="search-2" class="widget-container widget_search"><h3
									class="osLight sidebar-header">Search our Blog</h3>
								<form role="search" method="get" id="searchform"
									class="searchform"
									action="http://mariusn.com/themes/reales-wp/">
									<div>
										<label class="screen-reader-text" for="s">Search for:</label>
										<input type="text" value="" name="s" id="s" /> <input
											type="submit" id="searchsubmit" value="Search" />
									</div>
								</form></li> --%>
							<%-- <li id="featured_properties_widget-4"
								class="widget-container featured_properties_sidebar"><h3
									class="osLight sidebar-header">Featured Properties</h3>
								<div class="propsWidget">
									<ul class="propList">
										<li><a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/sophisticated-residence/index.html"><div
													class="image">
													<img
														src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2015/02/img-prop.jpg"
														alt="Featured Properties" />
												</div>
												<div class="info text-nowrap">
													<div class="name">Sophisticated Residence</div>
													<div class="address">600 40th Ave, San Francisco,
														94121, United States</div>
													<div class="price">
														$799,000 <span class="badge">For Sale</span>
													</div>
												</div>
												<div class="clearfix"></div></a></li>
										<li><a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/luxury-mansion/index.html"><div
													class="image">
													<img
														src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-5-1024x576.jpg"
														alt="Featured Properties" />
												</div>
												<div class="info text-nowrap">
													<div class="name">Luxury Mansion</div>
													<div class="address">10 Romain St, San Francisco,
														123456, Romania</div>
													<div class="price">
														$3,400/mo <span class="badge">For Rent</span>
													</div>
												</div>
												<div class="clearfix"></div></a></li>
										<li><a
											href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/elegant-apartment/index.html"><div
													class="image">
													<img
														src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-4.jpg"
														alt="Featured Properties" />
												</div>
												<div class="info text-nowrap">
													<div class="name">Elegant Apartment</div>
													<div class="address">1485 Guerrero St, San Francisco,
														94110, United States</div>
													<div class="price">
														$895,000 <span class="badge">For Sale</span>
													</div>
												</div>
												<div class="clearfix"></div></a></li>
									</ul>
								</div></li> --%>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>




	<div class="home-footer">
		<div class="page-wrapper">
			<div class="row">

				<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
					<%-- <ul class="footer-nav pb20">
						<li id="nav_menu-2" class="widget-container widget_nav_menu"><h3
								class="osLight footer-header">Properties</h3>
							<div class="menu-footer-menu-1-container">
								<ul id="menu-footer-menu-1" class="menu">
									<li id="menu-item-596"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-596"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/index37da.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Properties
											List</a></li>
									<li id="menu-item-597"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-597"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/elegant-apartment/index.html">Single
											Property</a></li>
									<li id="menu-item-598"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-598"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/elegant-apartment/index.html">Search
											by City: San Francisco</a></li>
									<li id="menu-item-599"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-599"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/index259b.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=29&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Search
											by Category: Apartment</a></li>
									<li id="menu-item-600"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-600"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/indexaa47.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=10&amp;search_min_price=&amp;search_max_price=">Search
											by Type: For Rent</a></li>
									<li id="menu-item-601"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-601"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/search-results/indexea21.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=700000">Search
											by Price: Less than $70,000</a></li>
								</ul>
							</div></li>
						<li id="nav_menu-3" class="widget-container widget_nav_menu"><h3
								class="osLight footer-header">Agents</h3>
							<div class="menu-footer-menu-2-container">
								<ul id="menu-footer-menu-2" class="menu">
									<li id="menu-item-602"
										class="menu-item menu-item-type-custom menu-item-object-custom menu-item-602"><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/agents/jane-smith/index.html">Agent
											Page</a></li>
								</ul>
							</div></li>
					</ul>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
					<ul class="footer-nav pb20">
						<li id="recent_properties_widget-4"
							class="widget-container recent_properties_sidebar"><h3
								class="osLight footer-header">Recently Listed Properties</h3>
							<div class="propsWidget">
								<ul class="propList">
									<li><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/modern-residence/index.html"><div
												class="image">
												<img
													src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-1.jpg"
													alt="Recently Listed Properties" />
											</div>
											<div class="info text-nowrap">
												<div class="name">Modern Residence</div>
												<div class="address">547 35th Ave, San Francisco,
													94121, United States</div>
												<div class="price">
													$1,495,000 <span class="badge">For Sale</span>
												</div>
											</div>
											<div class="clearfix"></div></a></li>
									<li><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/sophisticated-residence/index.html"><div
												class="image">
												<img
													src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2015/02/img-prop.jpg"
													alt="Recently Listed Properties" />
											</div>
											<div class="info text-nowrap">
												<div class="name">Sophisticated Residence</div>
												<div class="address">600 40th Ave, San Francisco,
													94121, United States</div>
												<div class="price">
													$799,000 <span class="badge">For Sale</span>
												</div>
											</div>
											<div class="clearfix"></div></a></li>
									<li><a
										href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/luxury-mansion/index.html"><div
												class="image">
												<img
													src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-5-1024x576.jpg"
													alt="Recently Listed Properties" />
											</div>
											<div class="info text-nowrap">
												<div class="name">Luxury Mansion</div>
												<div class="address">10 Romain St, San Francisco,
													123456, Romania</div>
												<div class="price">
													$3,400/mo <span class="badge">For Rent</span>
												</div>
											</div>
											<div class="clearfix"></div></a></li>
								</ul>
							</div></li>
					</ul>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
					<ul class="footer-nav pb20">
						<li id="recent-posts-3"
							class="widget-container widget_recent_entries">
							<h3 class="osLight footer-header">From our Blog</h3>
							<ul>
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/modern-two-level-pool-house-in-los-angeles/index.html">Modern
										Two-Level Pool House in Los Angeles</a></li>
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/private-contemporary-home-balancing-openness/index.html">Private
										Contemporary Home Balancing Openness</a></li>
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/stylish-modern-ranch-exuding-a-welcoming-feel/index.html">Stylish
										Modern Ranch Exuding a Welcoming Feel</a></li>
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/how-does-a-designer-home-look-like/index.html">How
										Does A Designer Home Look Like</a></li>
								<li><a
									href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/luminous-3-bedroom-apartment-flaunting-modern-style/index.html">Luminous
										3 Bedroom Apartment Flaunting Modern Style</a></li>
							</ul>
						</li>
					</ul>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
					<ul class="footer-nav pb20">
						<li id="contact_widget-2" class="widget-container contact_sidebar"><h3
								class="osLight footer-header">Get in Touch</h3>
							<ul>
								<li class="widget-phone"><span class="fa fa-phone"></span>
									(123) 456-7890</li>
								<li class="widget-address osLight"><p>196 Front St</p>
									<p>San Francisco, CA 94111</p>
									<p>United States</p></li>
							</ul></li>
						<li id="social_widget-2" class="widget-container social_sidebar"><h3
								class="osLight footer-header">Follow Us</h3>
							<ul>
								<li><a href="#facebook"
									class="btn btn-sm btn-icon btn-round btn-o btn-white"><span
										class="fa fa-facebook"></span></a> <a href="#twitter"
									class="btn btn-sm btn-icon btn-round btn-o btn-white"><span
										class="fa fa-twitter"></span></a> <a href="#google"
									class="btn btn-sm btn-icon btn-round btn-o btn-white"><span
										class="fa fa-google-plus"></span></a> <a href="#linkedin"
									class="btn btn-sm btn-icon btn-round btn-o btn-white"><span
										class="fa fa-linkedin"></span></a></li>
							</ul></li>
					</ul> --%>
				</div>


			</div>
			<div class="copyright">© 2015 </div>
		</div>
	</div>

	<script type='text/javascript'
		src='https://maps.googleapis.com/maps/api/js?sensor=true&amp;libraries=places&amp;ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/short-tax-post/js/bootstrap-datepicker5152.js?ver=1.0'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var property_vars = {"admin_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/","theme_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-content\/themes\/reales","plugins_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-content\/plugins\/short-tax-post\/images\/","browse_text":"Browse...","delete_photo":"Delete"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/short-tax-post/js/property5152.js?ver=1.0'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var agent_vars = {"admin_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/","theme_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-content\/themes\/reales","browse_text":"Browse..."};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/short-tax-post/js/agent5152.js?ver=1.0'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var testimonials_vars = {"admin_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/","theme_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-content\/themes\/reales","browse_text":"Browse..."};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/short-tax-post/js/testimonials5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/jquery-ui.min5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/jquery.placeholder5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/bootstrap5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/jquery.touchSwipe.min5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/jquery-ui-touch-punch5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/jquery.slimscroll.min5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/markerclusterer5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/bootstrap-datepicker5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/${pageContext.request.contextPath}/resources/PropertyPortal/assets/${pageContext.request.contextPath}/resources/PropertyPortal/assets/${pageContext.request.contextPath}/resources/PropertyPortal/assets/plus.google.com/js/client_platform5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/infobox5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/fileinput.min5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/image-scale.min5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/jquery.fancyboxd63f.js?ver=2.1.5'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var services_vars = {"admin_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/","signin_redirect":"http:\/\/mariusn.com\/themes\/reales-wp","theme_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-content\/themes\/reales","signup_loading":"Sending...","signup_text":"Sign Up","signin_loading":"Sending...","signin_text":"Sign In","forgot_loading":"Sending...","forgot_text":"Get New Password","reset_pass_loading":"Sending...","reset_pass_text":"Reset Password","fb_login_loading":"Sending...","fb_login_text":"Sign In with Facebook","fb_login_error":"Login cancelled or not fully authorized!","google_signin_loading":"Sending...","google_signin_text":"Sign In with Google","google_signin_error":"Signin cancelled or not fully authorized!","search_country":"","search_state":"","search_city":"","search_category":"0","search_type":"0","search_min_price":"","search_max_price":"","search_lat":"37.77024821511303","search_lng":"-122.44061568005372","search_bedrooms":"","search_bathrooms":"","search_neighborhood":"","search_min_area":"","search_max_area":"","search_unit":"sq ft","search_amenities":[],"sort":"newest","zoom":"13","infobox_close_btn":"Close","infobox_view_btn":"View","page":"0","post_id":"290","user_id":"0","update_property":"Update Property","marker_color":"#0eaaa6","saving_property":"Saving Property...","deleting_property":"Deleting Property...","home_redirect":"http:\/\/mariusn.com\/themes\/reales-wp","send_message":"Send Message","sending_message":"Sending Message...","updating_profile":"Updating Profile..."};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/services5152.js?ver=1.0'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var main_vars = {"no_city":"Please set location","max_price":"2500000","max_area":"5000","currency":"$","currency_pos":"before","unit":"sq ft","search_placeholder":"Search for...","top_admin_menu":"","idx_search_location":"Location","idx_search_category":"Category","idx_search_price_min":"Min price","idx_search_price_max":"Max price","idx_search_beds":"Bedrooms","idx_search_baths":"Bathrooms","idx_advanced_search":"Advanced Search","idx_advanced_filter":"Show advanced search options","idx_advanced_filter_hide":"Hide advanced search options"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/main5152.js?ver=1.0'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var ajax_vars = {"ajaxurl":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/admin-ajax.php","nonce":"8b1a3741d9","remove":"ef4db783e6","number":"1","upload_enabled":"1","confirmMsg":"Are you sure you want to delete this?","plupload":{"runtimes":"html5,flash,html4","browse_button":"aaiu-uploader","container":"aaiu-upload-container","file_data_name":"aaiu_upload_file","max_file_size":"100000000b","url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/admin-ajax.php?action=reales_upload&nonce=e21d9cdb2d","flash_swf_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-includes\/js\/plupload\/plupload.flash.swf","filters":[{"title":"Allowed Files","extensions":"jpg,gif,png"}],"multipart":true,"urlstream_upload":true}};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/ajax-upload5152.js?ver=1.0'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var ajax_vars = {"ajaxurl":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/admin-ajax.php","nonce":"f98c5b0a52","remove":"81aa1ce275","number":"1","upload_enabled":"1","confirmMsg":"Are you sure you want to delete this?","plupload":{"runtimes":"html5,flash,html4","browse_button":"aaiu-uploader-plans","container":"aaiu-upload-container-plans","file_data_name":"aaiu_upload_file_plans","max_file_size":"100000000b","url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/admin-ajax.php?action=reales_upload_plans&nonce=e21d9cdb2d","flash_swf_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-includes\/js\/plupload\/plupload.flash.swf","filters":[{"title":"Allowed Files","extensions":"jpg,gif,png"}],"multipart":true,"urlstream_upload":true}};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/themes/reales/js/plans-ajax-upload5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/ui/core.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/ui/widget.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/ui/position.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/ui/menu.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-includes/js/jquery/ui/autocomplete.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/plugins/dsidxpress/js/autocomplete9651.js?ver=2.1.23'></script>
</body>

<!-- Mirrored from mariusn.com/themes/reales-wp/blog/ by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 25 Sep 2015 12:39:20 GMT -->
</html>