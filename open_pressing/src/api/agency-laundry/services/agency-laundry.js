'use strict';

/**
 * agency-laundry service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::agency-laundry.agency-laundry');
