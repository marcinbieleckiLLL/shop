<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="own" uri="http://www.example.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="setup.jsp"/>
<body id="page-top">
<own:Navbar names="Shop,About,Portfolio,Contact,Log in" hrefs="/shop,#about,#portfolio,#contact,/login"/>
<!-- Header -->
<header>
    <div class="container">
        <div class="slider-container">
            <div class="intro-text">
                <div class="intro-lead-in">Welcome To Our Studio!</div>
                <div class="intro-heading">It's Nice To Meet You</div>
                <a href="#about" class="page-scroll btn btn-xl">Tell Me More</a>
            </div>
        </div>
    </div>
</header>
<section id="about" class="light-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>ABOUT</h2>
                    <p>A creative agency based on Candy Land, ready to boost your business with some beautifull templates. Lattes Agency is one of the best in town see more you will be amazed.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- about module -->
            <div class="col-md-3 text-center">
                <div class="mz-module-about">
                    <i class="fa fa-briefcase ot-circle"></i>
                    <h3>Web Development</h3>
                    <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</p>
                </div>
            </div>
            <!-- end about module -->
            <!-- about module -->
            <div class="col-md-3 text-center">
                <div class="mz-module-about">
                    <i class="fa fa-photo ot-circle"></i>
                    <h3>Visualisation</h3>
                    <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
                </div>
            </div>
            <!-- end about module -->
            <!-- about module -->
            <div class="col-md-3 text-center">
                <div class="mz-module-about">
                    <i class="fa fa-camera-retro ot-circle"></i>
                    <h3>Photography</h3>
                    <p>Accusamus et iusto odio dignissimos ducimus qui blanditiis</p>
                </div>
            </div>
            <!-- end about module -->
            <!-- about module -->
            <div class="col-md-3 text-center">
                <div class="mz-module-about">
                    <i class="fa fa-cube ot-circle"></i>
                    <h3>UI/UX Design</h3>
                    <p> Itaque earum rerum hic tenetur a sapiente, ut aut reiciendis maiores</p>
                </div>
            </div>
            <!-- end about module -->
        </div>
    </div>
    <!-- /.container -->
</section>
<section >
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="skills-text">
                    <h2>WE`RE CREATIVE</h2>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.<br><br>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur?</p>
                </div>
            </div>
            <div class="col-md-6">
                <!-- skill bar item -->
                <div class="skillbar-item">
                    <div class="skillbar-score">
                        <span class="score">90</span><span class="percent">%</span>
                    </div>
                    <div class="skillbar" data-percent="90%">
                        <h3>Web design</h3>
                        <div class="skillbar-bar">
                            <div class="skillbar-percent" style="width: 90%;">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- skill bar item -->
                <div class="skillbar-item">
                    <div class="skillbar-score">
                        <span class="score">80</span><span class="percent">%</span>
                    </div>
                    <div class="skillbar" data-percent="80%">
                        <h3>Development</h3>
                        <div class="skillbar-bar">
                            <div class="skillbar-percent" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- skill bar item -->
                <div class="skillbar-item">
                    <div class="skillbar-score">
                        <span class="score">85</span><span class="percent">%</span>
                    </div>
                    <div class="skillbar" data-percent="85%">
                        <h3>Photography</h3>
                        <div class="skillbar-bar">
                            <div class="skillbar-percent" style="width: 85%;">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- skill bar item -->
                <div class="skillbar-item">
                    <div class="skillbar-score">
                        <span class="score">70</span><span class="percent">%</span>
                    </div>
                    <div class="skillbar" data-percent="70%">
                        <h3>Marketing</h3>
                        <div class="skillbar-bar">
                            <div class="skillbar-percent" style="width: 70%;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="overlay-dark bg-img1 dark-bg short-section">
    <div class="container text-center">
        <div class="row">
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <h2 data-count="59">59</h2>
                    <h6>awards</h6>
                </div>
            </div>
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <h2 data-count="1054">1054</h2>
                    <h6>Clients</h6>
                </div>
            </div>
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <h2 data-count="34">34</h2>
                    <h6>Team</h6>
                </div>
            </div>
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <h2 data-count="154">154</h2>
                    <h6>Project</h6>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="portfolio" class="light-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>Portfolio</h2>
                    <p>Our portfolio is the best way to show our work, you can see here a big range of our work. Check them all and you will find what you are looking for.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- start portfolio item -->
            <div class="col-md-4">
                <div class="ot-portfolio-item">
                    <figure class="effect-bubba">
                        <img src="images/demo/portfolio-1.jpg" alt="img02" class="img-responsive" />
                        <figcaption>
                            <h2>Dean & Letter</h2>
                            <p>Branding, Design</p>
                            <a href="#" data-toggle="modal" data-target="#Modal-1">View more</a>
                        </figcaption>
                    </figure>
                </div>
            </div>
            <!-- end portfolio item -->
            <!-- start portfolio item -->
            <div class="col-md-4">
                <div class="ot-portfolio-item">
                    <figure class="effect-bubba">
                        <img src="images/demo/portfolio-2.jpg" alt="img02" class="img-responsive" />
                        <figcaption>
                            <h2>Startup Framework</h2>
                            <p>Branding, Web Design</p>
                            <a href="#" data-toggle="modal" data-target="#Modal-2">View more</a>
                        </figcaption>
                    </figure>
                </div>
            </div>
            <!-- end portfolio item -->
            <!-- start portfolio item -->
            <div class="col-md-4">
                <div class="ot-portfolio-item">
                    <figure class="effect-bubba">
                        <img src="images/demo/portfolio-3.jpg" alt="img02" class="img-responsive" />
                        <figcaption>
                            <h2>Lamp & Velvet</h2>
                            <p>Branding, Web Design</p>
                            <a href="#" data-toggle="modal" data-target="#Modal-3">View more</a>
                        </figcaption>
                    </figure>
                </div>
            </div>
            <!-- end portfolio item -->
        </div>
        <div class="row">
            <!-- start portfolio item -->
            <div class="col-md-4">
                <div class="ot-portfolio-item">
                    <figure class="effect-bubba">
                        <img src="images/demo/portfolio-4.jpg" alt="img02" class="img-responsive" />
                        <figcaption>
                            <h2>Smart Name</h2>
                            <p>Branding, Design</p>
                            <a href="#" data-toggle="modal" data-target="#Modal-4">View more</a>
                        </figcaption>
                    </figure>
                </div>
            </div>
            <!-- end portfolio item -->
            <!-- start portfolio item -->
            <div class="col-md-4">
                <div class="ot-portfolio-item">
                    <figure class="effect-bubba">
                        <img src="images/demo/portfolio-5.jpg" alt="img02" class="img-responsive" />
                        <figcaption>
                            <h2>Fast People</h2>
                            <p>Branding, Web Design</p>
                            <a href="#" data-toggle="modal" data-target="#Modal-5">View more</a>
                        </figcaption>
                    </figure>
                </div>
            </div>
            <!-- end portfolio item -->
            <!-- start portfolio item -->
            <div class="col-md-4">
                <div class="ot-portfolio-item">
                    <figure class="effect-bubba">
                        <img src="images/demo/portfolio-2.jpg" alt="img02" class="img-responsive" />
                        <figcaption>
                            <h2>Kites & Stars</h2>
                            <p>Branding, Web Design</p>
                            <a href="#" data-toggle="modal" data-target="#Modal-2">View more</a>
                        </figcaption>
                    </figure>
                </div>
            </div>
            <!-- end portfolio item -->
        </div>
    </div><!-- end container -->
</section>
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>Contact Us</h2>
                    <p>If you have some Questions or need Help! Please Contact Us!<br>We make Cool and Clean Design for your Business</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <h3>Our Business Office</h3>
                <p>3422 Street, Barcelona 432, Spain, New Building North, 15th Floor</p>
                <p><i class="fa fa-phone"></i> +101 377 655 22125</p>
                <p><i class="fa fa-envelope"></i> mail@yourcompany.com</p>
            </div>
            <div class="col-md-3">
                <h3>Business Hours</h3>
                <p><i class="fa fa-clock-o"></i> <span class="day">Weekdays:</span><span>9am to 8pm</span></p>
                <p><i class="fa fa-clock-o"></i> <span class="day">Saturday:</span><span>9am to 2pm</span></p>
                <p><i class="fa fa-clock-o"></i> <span class="day">Sunday:</span><span>Closed</span></p>
            </div>
            <div class="col-md-6">
                <form name="sentMessage" id="contactForm" novalidate="">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Name *" id="name" required="" data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *" id="email" required="" data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <textarea class="form-control" placeholder="Your Message *" id="message" required="" data-validation-required-message="Please enter a message."></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <button type="submit" class="btn">Send Message</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<p id="back-top">
    <a href="#top"><i class="fa fa-angle-up"></i></a>
</p>
<jsp:include page="footer.jsp"/>

<!-- Modal for portfolio item 1 -->
<div class="modal fade" id="Modal-1" tabindex="-1" role="dialog" aria-labelledby="Modal-label-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="Modal-label-1">Dean & Letter</h4>
            </div>
            <div class="modal-body">
                <img src="images/demo/portfolio-1.jpg" alt="img01" class="img-responsive" />
                <div class="modal-works"><span>Branding</span><span>Web Design</span></div>
                <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal for portfolio item 2 -->
<div class="modal fade" id="Modal-2" tabindex="-1" role="dialog" aria-labelledby="Modal-label-2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="Modal-label-2">Startup Framework</h4>
            </div>
            <div class="modal-body">
                <img src="images/demo/portfolio-2.jpg" alt="img01" class="img-responsive" />
                <div class="modal-works"><span>Branding</span><span>Web Design</span></div>
                <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal for portfolio item 3 -->
<div class="modal fade" id="Modal-3" tabindex="-1" role="dialog" aria-labelledby="Modal-label-3">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="Modal-label-3">Lamp & Velvet</h4>
            </div>
            <div class="modal-body">
                <img src="images/demo/portfolio-3.jpg" alt="img01" class="img-responsive" />
                <div class="modal-works"><span>Branding</span><span>Web Design</span></div>
                <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal for portfolio item 4 -->
<div class="modal fade" id="Modal-4" tabindex="-1" role="dialog" aria-labelledby="Modal-label-4">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="Modal-label-4">Smart Name</h4>
            </div>
            <div class="modal-body">
                <img src="images/demo/portfolio-4.jpg" alt="img01" class="img-responsive" />
                <div class="modal-works"><span>Branding</span><span>Web Design</span></div>
                <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal for portfolio item 5 -->
<div class="modal fade" id="Modal-5" tabindex="-1" role="dialog" aria-labelledby="Modal-label-5">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="Modal-label-5">Fast People</h4>
            </div>
            <div class="modal-body">
                <img src="images/demo/portfolio-5.jpg" alt="img01" class="img-responsive" />
                <div class="modal-works"><span>Branding</span><span>Web Design</span></div>
                <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>