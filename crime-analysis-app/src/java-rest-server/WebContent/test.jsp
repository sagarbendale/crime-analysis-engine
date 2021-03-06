<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tabbed List View Template</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet" href="common/css/app.min.css">
<script src="common/js/jQuery2.0.2.min.js"></script>
<script src="common/js/jquery.touchwipe.min.js"></script>
<script src="common/js/main.min.js"></script>
</head>
<body>
	<div class="app-wrapper">
		<nav class="main-menu">
			<a href="#">Something</a> <a href="#">Something</a> <a href="#">Something</a>
		</nav>
		<!--#main-menu-->
		<header>
			<div class="main-menu-button main-menu-button-left">
				<a class="menu">&nbsp;</a>
			</div>
			<div class="main-menu-button main-menu-button-right">
				<a class="gear">&nbsp;</a>
			</div>
			<h1>Contacts</h1>
		</header>
		<div class="app-content">
			<div class="tabbed-list-view-nav">
				<a href="#" class="span-50 on">Red Fish</a> <a href="#"
					class="span-50">Blue Fish</a>
				<div class="tabbed-list-view-nav-arrow">&nbsp;</div>
			</div>
			<ul class="tabbed-list-view">
				<li>
					<ul class="list-view with-swipe left-thumbs right-one-icons">
						<li>
							<div class="thumbs">
								<a href="#" class="thumb thumb-1"><img class="thumb"
									src="../common/images/icons/tile-phone.png"></a> <a href="#"
									class="thumb thumb-2"><img class="thumb"
									src="../common/images/icons/tile-email.png"></a> <img
									class="thumb thumb-3"
									src="../common/images/placeholders/contact-2.png">
							</div>
							<!-- .thumbs --> <a href="#" class="content">
								<h2>Rachel Aarons</h2> Project Manager
								<div class="list-view-icons">
									<span class="icon-right-arrow">&nbsp;</span>
								</div>
						</a>
						</li>
						<li>
							<div class="thumbs">
								<a href="#" class="thumb thumb-1"><img class="thumb"
									src="../common/images/icons/tile-phone.png"></a> <a href="#"
									class="thumb thumb-2"><img class="thumb"
									src="../common/images/icons/tile-email.png"></a> <img
									class="thumb thumb-3"
									src="../common/images/placeholders/contact-3.png">
							</div>
							<!-- .thumbs --> <a href="#" class="content">
								<h2>Nathan An</h2> Public Relations
								<div class="list-view-icons">
									<span class="icon-right-arrow">&nbsp;</span>
								</div>
						</a>
						</li>
					</ul>
				</li>
				<li>
					<ul class="list-view with-swipe left-thumbs right-one-icons">
						<li>
							<div class="thumbs">
								<a href="#" class="thumb thumb-1"><img class="thumb"
									src="../common/images/icons/tile-phone.png"></a> <a href="#"
									class="thumb thumb-2"><img class="thumb"
									src="../common/images/icons/tile-email.png"></a> <img
									class="thumb thumb-3"
									src="../common/images/placeholders/contact-1.png">
							</div>
							<!-- .thumbs --> <a href="#" class="content">
								<h2>Bruce Bryant</h2> IT Supervisor
								<div class="list-view-icons">
									<span class="icon-right-arrow">&nbsp;</span>
								</div>
						</a>
						</li>
						<li>
							<div class="thumbs">
								<a href="#" class="thumb thumb-1"><img class="thumb"
									src="../common/images/icons/tile-phone.png"></a> <a href="#"
									class="thumb thumb-2"><img class="thumb"
									src="../common/images/icons/tile-email.png"></a> <img
									class="thumb thumb-3"
									src="../common/images/placeholders/contact-4.png">
							</div>
							<!-- .thumbs --> <a href="#" class="content">
								<h2>Samantha Bard</h2> System Analyst
								<div class="list-view-icons">
									<span class="icon-right-arrow">&nbsp;</span>
								</div>
						</a>
						</li>
					</ul>
				</li>
			</ul>
			<!--.tabbed-list-view-->
		</div>
		<!--#app-content-->
	</div>
	<!--#app-wrapper-->
</body>
</html>