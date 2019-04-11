/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.vault.support;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Value object representing the result of a {@link Signature} validation.
 *
 * @author Mark Paluch
 * @since 2.0
 */
@EqualsAndHashCode
@ToString
public class SignatureValidation {

	private static final SignatureValidation VALID = new SignatureValidation(true);

	private static final SignatureValidation INVALID = new SignatureValidation(false);

	private final boolean state;

	private SignatureValidation(boolean state) {
		this.state = state;
	}

	/**
	 * Factory method to create a {@link SignatureValidation} object representing a
	 * successfully validated signature.
	 *
	 * @return a {@link SignatureValidation} object representing a successfully validated
	 * signature.
	 */
	public static SignatureValidation valid() {
		return VALID;
	}

	/**
	 * Factory method to create a {@link SignatureValidation} object representing a failed
	 * signature validation.
	 *
	 * @return a {@link SignatureValidation} object representing a failed signature
	 * validation.
	 */
	public static SignatureValidation invalid() {
		return INVALID;
	}

	public boolean isValid() {
		return state;
	}
}