/*
 * Copyright 2017, OpenCensus Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opencensus.implcore.tags;

import io.opencensus.common.Scope;
import io.opencensus.internal.NoopScope;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagContextBuilder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagKey.TagKeyBoolean;
import io.opencensus.tags.TagKey.TagKeyLong;
import io.opencensus.tags.TagKey.TagKeyString;
import io.opencensus.tags.TagValue.TagValueBoolean;
import io.opencensus.tags.TagValue.TagValueLong;
import io.opencensus.tags.TagValue.TagValueString;

/** {@link TagContextBuilder} that is used when tagging is disabled. */
final class NoopTagContextBuilder extends TagContextBuilder {
  static final NoopTagContextBuilder INSTANCE = new NoopTagContextBuilder();

  private NoopTagContextBuilder() {}

  @Override
  public TagContextBuilder put(TagKeyString key, TagValueString value) {
    return this;
  }

  @Override
  public TagContextBuilder put(TagKeyLong key, TagValueLong value) {
    return this;
  }

  @Override
  public TagContextBuilder put(TagKeyBoolean key, TagValueBoolean value) {
    return this;
  }

  @Override
  public TagContextBuilder remove(TagKey key) {
    return this;
  }

  @Override
  public TagContext build() {
    return TagContextImpl.EMPTY;
  }

  @Override
  public Scope buildScoped() {
    return NoopScope.getInstance();
  }
}
