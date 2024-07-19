import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-scroll-to-top',
  templateUrl: './scroll-to-top.component.html',
  styleUrls: ['./scroll-to-top.component.css']
})
export class ScrollToTopComponent implements OnInit {

  scrollToTopBtnVisible = false; 

  constructor() {}

  ngOnInit(): void {
    const target = document.querySelector('footer'); 

    
    const callback: IntersectionObserverCallback = (entries, observer) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          // Show button
          this.scrollToTopBtnVisible = true;
        } else {
          // Hide button
          this.scrollToTopBtnVisible = false;
        }
      });
    };

    
    const observer = new IntersectionObserver(callback);

    
    if (target) {
      observer.observe(target);
    }
  }

  scrollToTop(): void {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
