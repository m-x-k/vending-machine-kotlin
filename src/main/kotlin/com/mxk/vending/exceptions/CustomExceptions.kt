package com.mxk.vending.exceptions

class EmptyFundsException(msg: String? = null, cause: Throwable? = null): Exception(msg, cause)

class NotFoundException(msg: String? = null, cause: Throwable? = null): Exception(msg, cause)

class InsufficientFundsException(msg: String? = null, cause: Throwable? = null): Exception(msg, cause)