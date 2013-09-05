/*
 * Copyright (c) 2010-2012 Grid Dynamics Consulting Services, Inc, All Rights Reserved
 * http://www.griddynamics.com
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.griddynamics.jagger.invoker;

// @todo add an ability to use in xml configuration
public abstract class PairSupplierFactoryLoadBalancer<Q, E> extends QueryPoolLoadBalancer<Q, E> {

    protected PairSupplierFactory<Q, E> pairSupplierFactory;

    protected PairSupplier<Q, E> pairSupplier;

    public void setPairSupplierFactory(PairSupplierFactory<Q, E> pairSupplierFactory) {
        this.pairSupplierFactory = pairSupplierFactory;
    }

    @Override
    public void setEndpointProvider(Iterable<E> endpointProvider) {
        super.setEndpointProvider(endpointProvider);
        if (this.endpointProvider != null && this.queryProvider != null) {
            pairSupplier = pairSupplierFactory.create(this.queryProvider, this.endpointProvider);
        }
    }

    @Override
    public void setQueryProvider(Iterable<Q> queryProvider) {
        super.setQueryProvider(queryProvider);
        if (this.endpointProvider != null && this.queryProvider != null) {
            pairSupplier = pairSupplierFactory.create(this.queryProvider, this.endpointProvider);
        }
    }

}
