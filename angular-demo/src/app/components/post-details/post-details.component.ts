import { Component, OnInit } from '@angular/core';
import { PostService } from '../../services/post.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  //we need to get the path variable to specify which post it is we want to populate our page with
  //we then want to use that id to call to our api 
  //we're going to use a promise in order to get our post 
  //once it is resolved, we want to display the post information

  currentPost: Post = {
    id : undefined,
    userId : undefined,
    title : undefined,
    body : undefined
  };
  id: number;

  constructor(private postService: PostService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params =>
      this.id = params['id']
    )
    this.getPost(this.id)
    console.log(this.currentPost)
  }

  getPost(idParam: number){
    this.postService.getPost(idParam)
    .then((res)=>{
      this.currentPost = res;
      console.log(this.currentPost)
    })
    .catch((e)=>console.log(e))
  }

}
