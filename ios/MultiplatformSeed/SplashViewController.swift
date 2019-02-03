//
//  ViewController.swift
//  MultiplatformSeed
//
//  Created by Daniel Llanos Muñoz on 02/02/2019.
//  Copyright © 2019 Daniel Llanos Muñoz. All rights reserved.
//

import UIKit
import ios

class SplashViewController: UIViewController, SplashView {

    lazy var presenter: SplashPresenter = SplashPresenter(
        view: self,
        errorHandler: IosErrorHandler())

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    func showProgress() {
        
    }
    
    func hideProgress() {
        
    }
    
    func showError(error: String) {
        
    }
    
    func showMessage(message: String) {
        
    }

}

