<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="container-fluid">
		<div class="wrapper" id="main-container">
			<nav>
				<ul class="cd-primary-nav">
					<li><a href="index.html">Home</a></li>
					<li><a href="#">Our Services</a></li>
					<li><a href="#">Our Projects</a></li>
					<li><a href="#">Careers</a></li>
					<li><a href="#">Support</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</nav>
			<main class="main-content">
				<div class="logo-section"><img src="${pageContext.request.contextPath}/resources/PocPortal/assets/images/logo-m.png" alt="logo" title="logo"></div>
				<p class="tagline">Because the world needs great curated content</p>
				<div class="search">
					<form class="form-wrapper cf" action="showBook.htm" method="get"> 
        				<input type="text" placeholder="Search here..." required  name="searchKey">
        				<button type="submit">Search</button>
    				</form> 
				</div>
				<div class="discover-btn">
					<a href="#" class="myButton" data-toggle="modal" data-target="#myModal">Discover More</a>
				</div>
				<div class="modal fade" id="myModal" role="dialog">
    				<div class="modal-dialog">
      					<!-- Modal content-->
      					<div class="modal-content">
							<form name="discoverForm" method="" action="">
        						<div class="modal-header">
          							<button type="button" class="close" data-dismiss="modal">&times;</button>
          							<h4 class="modal-title popup-heading">Advance Discover</h4>
        						</div>
        						<div class="modal-body">
									<div id="firstOptions" class="firstOptions">
										<input id="nextBook" type="radio" name="discover" value="next book"><div class="label-text">I want to discover next book to read.</div>
										
										<input id="newAuthor" type="radio" name="discover" value="new author"><div class="label-text">I want to discover a new author.</div>
									</div>
									<div id="secondOptions" class="secondOptions">
										<input id="explore" type="radio" name="anotherDiscover" value="explore"><div class="label-text">I want to explore.</div>
										<input id="history" type="radio" name="anotherDiscover" value="reading history"><div class="label-text">I want to discover using my reading history.</div>
									</div>
									<div id="thirdOptions" class="thirdOptions">
										<div class="row">
											<div class="col-md-3">
												<span class="select-label">Age:</span>
											</div>
											<div class="col-md-9">
												<select name="selectAge" id="selectAge">
  													<option>Select Age</option>
  													<option value="30">30</option>
  													<option value="29">29</option>
													<option value="28">28</option>
  													<option value="27">27</option>
  													<option value="26">26</option>
  													<option value="25">25</option>
  													<option value="24">24</option>
  													<option value="23">23</option>
  													<option value="22">22</option>
  													<option value="21">21</option>
  													<option value="20">20</option>
												</select>
											</div>
										</div>
										<div class="fspace-5"></div>
										<div class="row">
											<div class="col-md-3">
												<span class="select-label">Difficulty Level:</span>
											</div>
											<div class="col-md-9">
												<select name="selectLevel" id="selectLevel">
  													<option>Select Difficulty Level</option>
	  												<option value="advanced">Advanced</option>
  													<option value="moderate">Moderate</option>
  													<option value="intermediate">Intermediate</option>
  													<option value="easy">Easy</option>
												</select>
											</div>
										</div>
										<div class="fspace-5"></div>
										<div class="row">
											<div class="col-md-3">
												<span class="select-label">Protagonist:</span>
											</div>
											<div class="col-md-9">
												<select name="selectProtagonist" id="selectProtagonist">
  													<option>Select Protagonist</option>
	  												<option value="advanced">Fiction</option>
  													<option value="moderate">Non-Fiction</option>
  													<option value="intermediate">Drama</option>
  													<option value="easy">Literature</option>
												</select>
											</div>
										</div>
									</div>
        						</div>
        						<div class="modal-footer">
          							<button type="button" class="myButton" data-dismiss="modal">Submit</button>
        						</div>
							</form>
      					</div>  
    				</div>
  				</div>
			</main>
			<footer class="footer">
				<div class="copyright">
					<span class="copyright-section"><i class="fa fa-copyright"></i>
 ABOOKZOO</span>
				</div>
				<div class="flinks">
					<ul class="fmenus1">
						<li><a href="#">About Us</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Projects</a></li>
						<li><a href="#">Careers</a></li>
					</ul>
				</div>
			</footer>
			<div class="cd-overlay-nav">
				<span></span>
			</div> <!-- cd-overlay-nav -->

			<div class="cd-overlay-content">
				<span></span>
			</div> <!-- cd-overlay-content -->

			<a href="#" class="cd-nav-trigger">Menu<span class="cd-icon"></span></a>
		</div>
	</div>