import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateChild,
  Router,
  RouterStateSnapshot,
  UrlTree
} from "@angular/router";

import {Observable} from "rxjs";
import {AuthenticationService} from "../login/authentication.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate, CanActivateChild {

  constructor(private authService: AuthenticationService,
              private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot,
              state: RouterStateSnapshot):
    Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if ((route["url"][0]["path"]).includes(this.authService.userRole) && this.authService.userRole != '')
        return true;
      else
        console.log(this.authService.userRole);
        this.router.navigate(['']);
        return false;
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if ((this.router.url).includes(this.authService.userRole) && this.authService.userRole != '')
      return true;
    else
      console.log(this.authService.userRole);
      this.router.navigate(['']);
      return false;
  }


}
