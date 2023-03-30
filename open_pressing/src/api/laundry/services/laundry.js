'use strict';

/**
 * laundry service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::laundry.laundry');
