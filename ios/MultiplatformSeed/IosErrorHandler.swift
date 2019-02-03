//
//  IosErrorHandler.swift
//  MultiplatformSeed
//
//  Created by Daniel Llanos Muñoz on 02/02/2019.
//  Copyright © 2019 Daniel Llanos Muñoz. All rights reserved.
//

import Foundation
import ios

class IosErrorHandler: NSObject, ErrorHandler {
    func convert(error: ios.Error) -> String {
        return ""
    }
}
