<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">

<!-- Mirrored from mariusn.com/themes/reales-wp/search-results/ by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 25 Sep 2015 12:44:18 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!-- /Added by HTTrack -->
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Properties Search Results | Properties N Loans</title>
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
<link rel='canonical' href='index.html' />
<link rel='shortlink'
	href='${pageContext.request.contextPath}/resources/PropertyPortal/assets/index1422.html?p=295' />
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


<body
	class="page page-id-295 page-template page-template-property-search-results page-template-property-search-results-php no-transition">

	<div id="header">
		<div class="logo">
			<a href="index.html"> <img
				src="${pageContext.request.contextPath}/resources/PropertyPortal/assets/images/logo1.png"
				style="height: 100px">
			</a>
		</div>
		<a href="javascript:void(0);" class="navHandler"><span
			class="fa fa-ellipsis-v"></span></a> <a href="javascript:void(0);"
			class="mapHandler"><span class="icon-map"></span></a>

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
								name="_wp_http_referer"
								value="/themes/reales-wp/search-results/" />
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
								name="_wp_http_referer"
								value="/themes/reales-wp/search-results/" />
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
								name="_wp_http_referer"
								value="/themes/reales-wp/search-results/" />
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
								value="/themes/reales-wp/search-results/" />
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
		</div>
		 --%>
		<a href="javascript:void(0);" class="top-navHandler visible-xs"><span
			class="fa fa-bars"></span></a>
		<div class="top-nav">
			<div class="menu-top-menu-container">
				<ul id="menu-top-menu" class="menu">
					<li id="menu-item-225"
						class="xxx menu-item menu-item-type-post_type menu-item-object-page menu-item-225"><a
						href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/index.html">Home</a></li>
					<%-- <li id="menu-item-556"
						class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-556"><a
						href="#">Properties</a>
						<ul class="sub-menu">
							<li id="menu-item-555"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-555"><a
								href="index37da.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Properties
									List</a></li>
							<li id="menu-item-557"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-557"><a
								href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/elegant-apartment/index.html">Single
									Property</a></li>
							<li id="menu-item-558"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-558"><a
								href="index37da.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Search
									by City</a></li>
							<li id="menu-item-559"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-559"><a
								href="index259b.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=29&amp;search_type=0&amp;search_min_price=&amp;search_max_price=">Search
									by Category</a></li>
							<li id="menu-item-560"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-560"><a
								href="indexaa47.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=10&amp;search_min_price=&amp;search_max_price=">Search
									by Type</a></li>
							<li id="menu-item-561"
								class="menu-item menu-item-type-custom menu-item-object-custom menu-item-561"><a
								href="indexea21.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price=700000">Search
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
						class="menu-item menu-item-type-post_type menu-item-object-page menu-item-269"><a
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
						href="./contactUs.htm">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>

	<%-- <div id="leftSide">
		<nav class="leftNav scrollable">
			<div class="menu-leftside-menu-container">
				<ul id="menu-leftside-menu" class="menu">
					<li id="menu-item-603"
						class="icon-globe menu-item menu-item-type-custom menu-item-object-custom menu-item-603"><a
						href="index37da.html?search_city=San+Francisco&amp;search_lat=37.7749295&amp;search_lng=-122.41941550000001&amp;search_category=0&amp;search_type=0&amp;search_min_price=&amp;search_max_price="><span
							class="navIcon"></span><span class="navLabel">Explore</span></a></li>
					<li id="menu-item-604"
						class="icon-plus menu-item menu-item-type-custom menu-item-object-custom menu-item-604"><a
						href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/front-end-property-submission/index.html"><span
							class="navIcon"></span><span class="navLabel">Submit</span></a></li>
					<li id="menu-item-605"
						class="icon-heart menu-item menu-item-type-custom menu-item-object-custom menu-item-605"><a
						href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/favourite-properties/index.html"><span
							class="navIcon"></span><span class="navLabel">Favourites</span></a></li>
					<li id="menu-item-606"
						class="icon-folder menu-item menu-item-type-custom menu-item-object-custom menu-item-606"><a
						href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/front-end-property-submission/index.html"><span
							class="navIcon"></span><span class="navLabel">My Listings</span></a></li>
					<li id="menu-item-608"
						class="icon-support menu-item menu-item-type-custom menu-item-object-custom menu-item-608"><a
						href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/contact-us/index.html"><span
							class="navIcon"></span><span class="navLabel">Support</span></a></li>
				</ul>
			</div>
		</nav>
	</div> --%>
	<div class="closeLeftSide"></div>


	<div id="wrapper">

		<input type="hidden" id="securityAppMap" name="securityAppMap"
			value="83a27c0484" /><input type="hidden" name="_wp_http_referer"
			value="/themes/reales-wp/search-results/" />
		<div id="content" style="width: 90%;">

			<!-- <div class="filter">
    <h3>Filter your results</h3>
    <a href="javascript:void(0);" class="handleFilter"><span class="icon-equalizer"></span></a>
    <div class="clearfix"></div>
    <form class="filterForm" id="filterPropertyForm" role="search" method="get" action="http://mariusn.com/themes/reales-wp/search-results/">
        <input type="hidden" name="search_lat" id="search_lat" value="" autocomplete="off" />
        <input type="hidden" name="search_lng" id="search_lng" value="" autocomplete="off" />
        <input type="hidden" name="sort" id="sort" value="newest" autocomplete="off" />

        <div class="row">
                                </div>
        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="form-group">
                        <label>City</label>
                        <input type="text" class="form-control" name="search_city" id="search_city" value="" placeholder="Enter city" autocomplete="off" />
                    </div>
                </div>
				
				 <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 formItem">
                    <div class="formField">
                        <label>Price Range</label>
                        <input type="hidden" name="search_min_price" id="search_min_price" value="" />
                        <input type="hidden" name="search_max_price" id="search_max_price" value="" />
                        <div class="slider priceSlider">
                            <div class="sliderTooltip">
                                <div class="stArrow"></div>
                                <div class="stLabel"></div>
                            </div>
                        </div>
                    </div>
                </div>
				
				 <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 formItem">
                                            <div class="form-group fg-inline">
                            <label for="search_category">Category</label>
                            <a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-o btn-light-gray dropdown-toggle">
                                <span class="dropdown-label">Category</span>&nbsp;&nbsp;&nbsp;<span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-select">
                                <li class="active"><input type="radio" name="search_category" value="0" checked="checked" ><a href="javascript:void(0);">Category</a></li>
                                                                <li><input type="radio" name="search_category" value="29" ><a href="javascript:void(0);">Apartment</a></li>
                                                                <li><input type="radio" name="search_category" value="30" ><a href="javascript:void(0);">House</a></li>
                                                                <li><input type="radio" name="search_category" value="31" ><a href="javascript:void(0);">Land</a></li>
                                                            </ul>
                        </div>
                                                                <div class="form-group fg-inline">
                            <label for="search_type">Type</label>
                            <a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-o btn-light-gray dropdown-toggle">
                                <span class="dropdown-label">Type</span>&nbsp;&nbsp;&nbsp;<span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-select">
                                <li class="active"><input type="radio" name="search_type" value="0" checked="checked" ><a href="javascript:void(0);">Type</a></li>
                                                                <li><input type="radio" name="search_type" value="10" ><a href="javascript:void(0);">For Rent</a></li>
                                                                <li><input type="radio" name="search_type" value="11" ><a href="javascript:void(0);">For Sale</a></li>
                                                            </ul>
                        </div>
                                    </div>
                    </div>
        <div class="row">
                           
                                       
                    </div>
        <div id="advancedFilter">
            <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 formItem">
                                                    <div class="form-group fg-inline">
                                <label>Bedrooms</label>
                                <a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-o btn-light-gray dropdown-toggle">
                                    <span class="dropdown-label">Bedrooms</span>&nbsp;&nbsp;&nbsp;<span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-select">
                                    <li class="active"><input type="radio" name="search_bedrooms" value="0" checked="checked" ><a href="javascript:void(0);">Bedrooms</a></li>
                                    <li><input type="radio" name="search_bedrooms" value="1"  ><a href="javascript:void(0);">1+</a></li>
                                    <li><input type="radio" name="search_bedrooms" value="2"  ><a href="javascript:void(0);">2+</a></li>
                                    <li><input type="radio" name="search_bedrooms" value="3"  ><a href="javascript:void(0);">3+</a></li>
                                    <li><input type="radio" name="search_bedrooms" value="4"  ><a href="javascript:void(0);">4+</a></li>
                                    <li><input type="radio" name="search_bedrooms" value="5"  ><a href="javascript:void(0);">5+</a></li>
                                </ul>
                            </div>
                                                                            <div class="form-group fg-inline">
                                <label>Bathrooms</label>
                                <a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-o btn-light-gray dropdown-toggle">
                                    <span class="dropdown-label">Bathrooms</span>&nbsp;&nbsp;&nbsp;<span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-select">
                                    <li class="active"><input type="radio" name="search_bathrooms" value="0" checked="checked"><a href="javascript:void(0);">Bathrooms</a></li>
                                    <li><input type="radio" name="search_bathrooms" value="1"  ><a href="javascript:void(0);">1+</a></li>
                                    <li><input type="radio" name="search_bathrooms" value="2"  ><a href="javascript:void(0);">2+</a></li>
                                    <li><input type="radio" name="search_bathrooms" value="3"  ><a href="javascript:void(0);">3+</a></li>
                                    <li><input type="radio" name="search_bathrooms" value="4"  ><a href="javascript:void(0);">4+</a></li>
                                    <li><input type="radio" name="search_bathrooms" value="5"  ><a href="javascript:void(0);">5+</a></li>
                                </ul>
                            </div>
                                            </div>
											   <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 formItem">
                        <div class="formField">
                            <label>Area Range</label>
                            <input type="hidden" name="search_min_area" id="search_min_area" value="" />
                            <input type="hidden" name="search_max_area" id="search_max_area" value="" />
                            <div class="slider areaSlider">
                                <div class="sliderTooltip">
                                    <div class="stArrow"></div>
                                    <div class="stLabel"></div>
                                </div>
                            </div>
                        </div>
                    </div>
					                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 formItem">
                        <div class="form-group">
                            <label for="search_neighborhood">Neighborhood</label>
                            <input type="text" class="form-control" name="search_neighborhood" id="search_neighborhood" value="" placeholder="Enter neighborhood" />
                        </div>
                    </div>
                            </div>
           

            <div class="row"><div class="col-xs-12 col-sm-12 col-md-12  formItem"><div class="form-group"><label>Amenities</label><div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                <div class="checkbox custom-checkbox">
                                    <label><input type="checkbox" name="garage" value="1"  />
                                    <span class="fa fa-check"></span> Garage</label>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                <div class="checkbox custom-checkbox">
                                    <label><input type="checkbox" name="security_system" value="1"  />
                                    <span class="fa fa-check"></span> Security System</label>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                <div class="checkbox custom-checkbox">
                                    <label><input type="checkbox" name="air_conditioning" value="1"  />
                                    <span class="fa fa-check"></span> Air Conditioning</label>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                <div class="checkbox custom-checkbox">
                                    <label><input type="checkbox" name="balcony" value="1"  />
                                    <span class="fa fa-check"></span> Balcony</label>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                <div class="checkbox custom-checkbox">
                                    <label><input type="checkbox" name="outdoor_pool" value="1"  />
                                    <span class="fa fa-check"></span> Outdoor Pool</label>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                <div class="checkbox custom-checkbox">
                                    <label><input type="checkbox" name="internet" value="1"  />
                                    <span class="fa fa-check"></span> Internet</label>
                                </div>
                            </div></div></div></div></div>        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <div class="form-group">
                    <a href="javascript:void(0);" class="btn btn-green mb-10" id="filterPropertySubmit">Apply Filter</a>
                    <a href="javascript:void(0);" class="btn btn-gray display mb-10" id="showAdvancedFilter">Show Advanced Filter Options</a>
                    <a href="javascript:void(0);" class="btn btn-gray mb-10" id="hideAdvancedFilter">Hide Advanced Filter Options</a>
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix"></div>
</div> -->
			<div class="filter"></div>
			<div class="pull-left search_prop_calc" style="width: 100%;">
				<h1 class="pull-left">Properties Search Results</h1>
			</div>

			<div class="resultsList">
				<div class="pull-right sort">

					<!-- <div class="form-group">
						Sort by:&nbsp;&nbsp; <a href="javascript:void(0);"
							data-toggle="dropdown" class="btn btn-white dropdown-toggle">
							<span class="dropdown-label">Newest</span>&nbsp;&nbsp;&nbsp;<span
							class="caret"></span>
						</a>
						<ul class="dropdown-menu dropdown-select sorter">
							<li class="active"><input type="radio" name="sort"
								value="newest" checked="checked"><a
								href="javascript:void(0);">Newest</a></li>
							<li><input type="radio" name="sort" value="price_lo"><a
								href="javascript:void(0);">Price (Lo-Hi)</a></li>
							<li><input type="radio" name="sort" value="price_hi"><a
								href="javascript:void(0);">Price (Hi-Lo)</a></li>
							<li><input type="radio" name="sort" value="bedrooms"><a
								href="javascript:void(0);">Bedrooms</a></li>
							<li><input type="radio" name="sort" value="bathrooms"><a
								href="javascript:void(0);">Bathrooms</a></li>
							<li><input type="radio" name="sort" value="area"><a
								href="javascript:void(0);">Area</a></li>
						</ul>
					</div> -->
				</div>
				<c:if test="${empty projectList}">
					<div>
						<h2 class="pageHeader">
							<span style="color: red;">${NOPROJECTSFOUND}</span>
						</h2>
					</div>
				</c:if>
				<c:if test="${not empty projectList}">
					<c:forEach items="${projectList}" var="projectDto">
						<!-- <div class="row"> -->

						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<a href="singleProperty.htm?id=${projectDto.id}" class="card"
								id="card-313">
								<div class="figure">
									<div class="img"
										style="background-image:url(${projectDto.imageUrl});"></div>
									<div class="figCaption">
										<div>${projectDto.cost}</div>
										<input type="hidden" name="id" value="${projectDto.id}">
										<span><span class="icon-eye"></span> 999+</span> <span><span
											class="icon-heart"></span> 3</span> <span><span
											class="icon-bubble"></span> 1</span>
									</div>
									<div class="figView">
										<span class="icon-eye"></span>
									</div>
									<div class="figType">For Sale</div>
								</div>
								<h2>${projectDto.popertyName}</h2>
								<div class="cardAddress">
									${projectDto.siteAddress}
									<td>${projectDto.imageUrl}</td>
								</div> <!-- <ul class="cardFeat">
								<li><span class="fa fa-moon-o"></span> 4</li>
								<li><span class="icon-drop"></span> 4</li>
								<li><span class="icon-frame"></span> 2225 sq ft</li>
							</ul> -->
							</a>

						</div>
					</c:forEach>
				</c:if>
				<%-- <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
						<a href="singleProperty.htm" class="card" id="card-309">
							<div class="figure">
								<div class="img"
									style="background-image:url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2015/02/img-prop.jpg);"></div>
								<div class="figCaption">
									<div>$799,000</div>
									<span><span class="icon-eye"></span> 999+</span> <span><span
										class="icon-heart"></span> 2</span> <span><span
										class="icon-bubble"></span> 1</span>
								</div>
								<div class="figView">
									<span class="icon-eye"></span>
								</div>
								<div class="figType">For Sale</div>
							</div>
							<h2>Sophisticated Residence</h2>
							<div class="cardAddress">
								600 40th Ave, Richmond District, San Francisco<br />CA, 94121,
								United States
							</div>
							<ul class="cardFeat">
								<li><span class="fa fa-moon-o"></span> 2</li>
								<li><span class="icon-drop"></span> 3</li>
								<li><span class="icon-frame"></span> 1270 sq ft</li>
							</ul>
							<div class="clearfix"></div>
						</a>
					</div>
					 --%>
				<%-- <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/luxury-mansion/index.html"
							class="card" id="card-312">
							<div class="figure">
								<div class="img"
									style="background-image:url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-5-1024x576.jpg);"></div>
								<div class="figCaption">
									<div>$3,400/mo</div>
									<span><span class="icon-eye"></span> 999+</span> <span><span
										class="icon-heart"></span> 2</span> <span><span
										class="icon-bubble"></span> 1</span>
								</div>
								<div class="figView">
									<span class="icon-eye"></span>
								</div>
								<div class="figType">For Rent</div>
							</div>
							<h2>Luxury Mansion</h2>
							<div class="cardAddress">
								10 Romain St, Twin Peaks, San Francisco<br />CA, 123456,
								Romania
							</div>
							<ul class="cardFeat">
								<li><span class="fa fa-moon-o"></span> 2</li>
								<li><span class="icon-drop"></span> 1</li>
								<li><span class="icon-frame"></span> 1220 sq ft</li>
							</ul>
							<div class="clearfix"></div>
						</a>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/elegant-apartment/index.html"
							class="card" id="card-174">
							<div class="figure">
								<div class="img"
									style="background-image:url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-4.jpg);"></div>
								<div class="figCaption">
									<div>$895,000</div>
									<span><span class="icon-eye"></span> 999+</span> <span><span
										class="icon-heart"></span> 1</span> <span><span
										class="icon-bubble"></span> 1</span>
								</div>
								<div class="figView">
									<span class="icon-eye"></span>
								</div>
								<div class="figType">For Sale</div>
							</div>
							<h2>Elegant Apartment</h2>
							<div class="cardAddress">
								1485 Guerrero St, Noe Valley, San Francisco<br />CA, 94110,
								United States
							</div>
							<ul class="cardFeat">
								<li><span class="fa fa-moon-o"></span> 2</li>
								<li><span class="icon-drop"></span> 1</li>
								<li><span class="icon-frame"></span> 1200 sq ft</li>
							</ul>
							<div class="clearfix"></div>
						</a>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/futuristic-apartment/index.html"
							class="card" id="card-172">
							<div class="figure">
								<div class="img"
									style="background-image:url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2015/01/blog-4.jpg);"></div>
								<div class="figCaption">
									<div>$5,400/mo</div>
									<span><span class="icon-eye"></span> 999+</span> <span><span
										class="icon-heart"></span> 2</span> <span><span
										class="icon-bubble"></span> 1</span>
								</div>
								<div class="figView">
									<span class="icon-eye"></span>
								</div>
								<div class="figType">For Rent</div>
							</div>
							<h2>Futuristic Apartment</h2>
							<div class="cardAddress">
								333 Bush St #3804, Financial District, San Francisco<br />CA,
								94104, United States
							</div>
							<ul class="cardFeat">
								<li><span class="fa fa-moon-o"></span> 2</li>
								<li><span class="icon-drop"></span> 2</li>
								<li><span class="icon-frame"></span> 1510 sq ft</li>
							</ul>
							<div class="clearfix"></div>
						</a>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
						<a
							href="${pageContext.request.contextPath}/resources/PropertyPortal/assets/properties/stylish-apartment/index.html"
							class="card" id="card-167">
							<div class="figure">
								<div class="img"
									style="background-image:url(${pageContext.request.contextPath}/resources/PropertyPortal/assets/wp-content/uploads/2014/12/bg-3.jpg);"></div>
								<div class="figCaption">
									<div>$4,800/mo</div>
									<span><span class="icon-eye"></span> 999+</span> <span><span
										class="icon-heart"></span> 2</span> <span><span
										class="icon-bubble"></span> 1</span>
								</div>
								<div class="figView">
									<span class="icon-eye"></span>
								</div>
								<div class="figType">For Rent</div>
							</div>
							<h2>Stylish Apartment</h2>
							<div class="cardAddress">
								2200 Pacific Ave #7D, Pacific Heights, San Francisco<br />CA,
								94115, United States
							</div>
							<ul class="cardFeat">
								<li><span class="fa fa-moon-o"></span> 2</li>
								<li><span class="icon-drop"></span> 2</li>
								<li><span class="icon-frame"></span> 1850 sq ft</li>
							</ul>
							<div class="clearfix"></div>
						</a>
					</div>
				</div>
 --%>
				<div class="pull-left"></div>
				<div class="pull-right search_prop_calc">1 - 6 of 6 Properties
					found</div>
				<div class="clearfix"></div>
			</div>
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
var services_vars = {"admin_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-admin\/","signin_redirect":"http:\/\/mariusn.com\/themes\/reales-wp","theme_url":"http:\/\/mariusn.com\/themes\/reales-wp\/wp-content\/themes\/reales","signup_loading":"Sending...","signup_text":"Sign Up","signin_loading":"Sending...","signin_text":"Sign In","forgot_loading":"Sending...","forgot_text":"Get New Password","reset_pass_loading":"Sending...","reset_pass_text":"Reset Password","fb_login_loading":"Sending...","fb_login_text":"Sign In with Facebook","fb_login_error":"Login cancelled or not fully authorized!","google_signin_loading":"Sending...","google_signin_text":"Sign In with Google","google_signin_error":"Signin cancelled or not fully authorized!","search_country":"","search_state":"","search_city":"","search_category":"0","search_type":"0","search_min_price":"","search_max_price":"","search_lat":"37.77024821511303","search_lng":"-122.44061568005372","search_bedrooms":"","search_bathrooms":"","search_neighborhood":"","search_min_area":"","search_max_area":"","search_unit":"sq ft","search_amenities":[],"sort":"newest","zoom":"13","infobox_close_btn":"Close","infobox_view_btn":"View","page":"0","post_id":"295","user_id":"0","update_property":"Update Property","marker_color":"#0eaaa6","saving_property":"Saving Property...","deleting_property":"Deleting Property...","home_redirect":"http:\/\/mariusn.com\/themes\/reales-wp","send_message":"Send Message","sending_message":"Sending Message...","updating_profile":"Updating Profile..."};
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

<!-- Mirrored from mariusn.com/themes/reales-wp/search-results/ by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 25 Sep 2015 12:44:18 GMT -->
</html>